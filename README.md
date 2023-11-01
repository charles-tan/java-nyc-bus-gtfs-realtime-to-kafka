# java-nyc-bus-gtfs-realtime-to-kafka
Ingests data from gtfs-realtime and produces the feed to Kafka, specifically for NYC bus data

Website link to source data: https://bustime.mta.info/wiki/Developers/GTFSRt

The gtfs-realtime framework works by consistently updating the data available by HTTP request. 
This Java application consistently polls these pages, converts these protobuf feed events to JSON, then produces these individual events to Kafka.
The Kafka bootstrap URLs and other configurations are passed as program arguments to the Java application.

## Prerequisites
- Unix-like environment (Linux, Mac OS X)
- Java 17
- Maven (While other versions may work, I used version 3.9.0)
- Request a developer key for the dataset: https://bustime.mta.info/wiki/Developers/GTFSRt

## Build Instructions
`mvn clean package` to generate the JAR in the `target` directory

## Run Instructions

1. `export TRANSIT_KEY=<your_developer_key>`

2. Run java application (`producer.config` is optional if you need to pass in Kafka credentials)
    ```
    java -cp ./target/TransitRealtimeApp-jar-with-dependencies.jar App \
    --bootstrap.servers "<your comma separated kafka bootstrap servers>" \
    --producer.config "<file path to your kafka producer configuration>"
    ```

    An example of the Kafka producer configuration:
    ```
    security.protocol=SASL_SSL
    # kafka.client.truststore.jks is the copy of standard jvm cacert
    ssl.truststore.location=/Users/myusername/truststores/kafka.client.truststore.jks
    ssl.truststore.password=changeit
    sasl.mechanism=PLAIN
    sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule required \
       username="<username>" \
       password="<password>";
    ```