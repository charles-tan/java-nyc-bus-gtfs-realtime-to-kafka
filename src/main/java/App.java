import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class App {

    public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    public static final String PRODUCER_CONFIG = "producer.config";

    public static void main(String[] args) throws Exception {
        App app = new App();
        Map<String, Object> argsMap = app.parseArgs(args);
        String key = System.getenv("TRANSIT_KEY");
        GtfsService gtfsService = new GtfsService(key, (String) argsMap.get(BOOTSTRAP_SERVERS),
            (String) argsMap.getOrDefault(PRODUCER_CONFIG, null));
        ThreadPoolExecutor executor =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            gtfsService.handleTripUpdates();
            return null;
        });
        executor.submit(() -> {
            gtfsService.handleAlerts();
            return null;
        });
        executor.submit(() -> {
            gtfsService.handleVehiclePositions();
            return null;
        });
    }

    private Map<String, Object> parseArgs(final String[] args) {
        ArgumentParser argumentParser = ArgumentParsers.newFor("NycBusFeedIngestionApp")
            .build()
            .defaultHelp(true)
            .description(
                "An app to ingest NYC real-time bus feed events and produce those events to Kafka (https://bustime.mta.info/wiki/Developers/GTFSRt)");

        argumentParser
            .addArgument("--" + BOOTSTRAP_SERVERS)
            .help("The url to Kafka broker(s).")
            .required(true);
        argumentParser
            .addArgument("--" + PRODUCER_CONFIG)
            .help("The path to the Kafka producer config properties file.");

        Namespace namespace = null;
        try {
            namespace = argumentParser.parseArgs(args);
        } catch (ArgumentParserException e) {
            argumentParser.handleError(e);
            System.exit(1);
        }

        return namespace.getAttrs();
    }
}
