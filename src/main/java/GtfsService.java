import com.google.common.base.Preconditions;
import com.google.protobuf.util.JsonFormat;
import com.google.transit.realtime.Alert;
import com.google.transit.realtime.FeedEntity;
import com.google.transit.realtime.FeedMessage;
import com.google.transit.realtime.TripUpdate;
import com.google.transit.realtime.VehiclePosition;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class GtfsService {

    private String key;
    private Properties kafkaProps;
    final private int DEFAULT_PARTITIONS = 1;
    final private short DEFAULT_REPLICAS = 3;

    public GtfsService(String key, String bootstrapServer, String kafkaConfigFile) throws IOException {
        this.key = key;
        this.kafkaProps = this.getKafkaProps(bootstrapServer, kafkaConfigFile);
    }

    private Properties getKafkaProps(String bootstrapServer, String kafkaConfigFile) throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServer);
        props.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        if (kafkaConfigFile != null) {
            final InputStream inputStream = new FileInputStream(kafkaConfigFile);
            props.load(inputStream);
            inputStream.close();
        }
        return props;
    }

    private void createTopicIfNotExists(
        final Properties props, final String topicName, int partitions, short replicas)
        throws ExecutionException, InterruptedException {
        try (final AdminClient adminClient = AdminClient.create(props)) {
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            final Set<String> topicNames;
            try {
                topicNames = listTopicsResult.names().get(10000, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                throw new RuntimeException("Timed out attempting to fetch kafka topics: " + e);
            }
            if (topicNames.contains(topicName)) {
                System.out.println("Topic " + topicName + " already exists");
                return;
            }
            System.out.println("Creating new topic: " + topicName);
            NewTopic newTopic = new NewTopic(topicName, partitions, replicas);
            CreateTopicsResult res = adminClient.createTopics(List.of(newTopic));
            try {
                res.all().get(10000, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                throw new RuntimeException(
                    String.format("Timed out attempting to create kafka topic '%s': %s", newTopic, e));
            }
        }
    }

    private List<FeedEntity> getFeedEntities(URL url) throws IOException {
        return FeedMessage.parseFrom(url.openConnection().getInputStream()).getEntityList();
    }

    public void handleTripUpdates() throws IOException, InterruptedException, ExecutionException {
        String topicName = "nyc_bus_trip_updates";
        String uri = "https://gtfsrt.prod.obanyc.com/tripUpdates?key=" + this.key;
        this.createTopicIfNotExists(this.kafkaProps, topicName, DEFAULT_PARTITIONS, DEFAULT_REPLICAS);
        try (Producer<byte[], byte[]> producer = new KafkaProducer<>(kafkaProps)) {
            Set<String> seenFeed = new HashSet<>();
            while (true) {
                List<FeedEntity> feedEntityList = this.getFeedEntities(new URL(uri));
                Set<String> currentFeed = new HashSet<>();
                for (FeedEntity feed : feedEntityList) {
                    Preconditions.checkState(feed.hasTripUpdate(),
                        String.format("Expected TripUpdate feed [Entity ID: %s]", feed.getId()));
                    currentFeed.add(feed.getId());
                    TripUpdate tripUpdate = feed.getTripUpdate();
                    if (!seenFeed.contains(feed.getId())) {
                        if (tripUpdate.hasDelay()) {
                            ProducerRecord record = new ProducerRecord(topicName,
                                JsonFormat.printer().print(tripUpdate).getBytes());
                            producer.send(record);
                        }
                    } else {
                        continue;
                    }
                }
                seenFeed = currentFeed;
                Thread.sleep(2000);
            }
        }
    }

    public void handleAlerts() throws IOException, InterruptedException, ExecutionException {
        String topicName = "nyc_bus_alerts";
        String uri = "https://gtfsrt.prod.obanyc.com/alerts?key=" + this.key;
        this.createTopicIfNotExists(this.kafkaProps, topicName, DEFAULT_PARTITIONS, DEFAULT_REPLICAS);
        try (Producer<byte[], byte[]> producer = new KafkaProducer<>(kafkaProps)) {
            Set<String> seenFeed = new HashSet<>();
            while (true) {
                List<FeedEntity> feedEntityList = this.getFeedEntities(new URL(uri));
                Set<String> currentFeed = new HashSet<>();
                for (FeedEntity feed : feedEntityList) {
                    Preconditions.checkState(feed.hasAlert(),
                        String.format("Expected Alert feed [Entity ID: %s]", feed.getId()));
                    currentFeed.add(feed.getId());
                    Alert alert = feed.getAlert();
                    if (!seenFeed.contains(feed.getId())) {
                        ProducerRecord record = new ProducerRecord(topicName,
                            JsonFormat.printer().print(alert).getBytes());
                        producer.send(record);
                    } else {
                        continue;
                    }
                }
                seenFeed = currentFeed;
                Thread.sleep(2000);
            }
        }
    }

    public void handleVehiclePositions() throws IOException, InterruptedException, ExecutionException {
        String topicName = "nyc_bus_vehicle_positions";
        String uri = "https://gtfsrt.prod.obanyc.com/vehiclePositions?key=" + this.key;
        this.createTopicIfNotExists(this.kafkaProps, topicName, DEFAULT_PARTITIONS, DEFAULT_REPLICAS);
        try (Producer<byte[], byte[]> producer = new KafkaProducer<>(kafkaProps)) {
            Set<String> seenFeed = new HashSet<>();
            while (true) {
                List<FeedEntity> feedEntityList = this.getFeedEntities(new URL(uri));
                Set<String> currentFeed = new HashSet<>();
                for (FeedEntity feed : feedEntityList) {
                    Preconditions.checkState(feed.hasVehicle(),
                        String.format("Expected Vehicle feed [Entity ID: %s]", feed.getId()));
                    currentFeed.add(feed.getId());
                    VehiclePosition vehiclePosition = feed.getVehicle();
                    if (!seenFeed.contains(feed.getId())) {
                        ProducerRecord record = new ProducerRecord(topicName,
                            JsonFormat.printer().print(vehiclePosition).getBytes());
                        producer.send(record);
                    } else {
                        continue;
                    }
                }
                seenFeed = currentFeed;
                Thread.sleep(2000);
            }
        }
    }
}
