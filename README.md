# Network Traffic Capture
A Application capture traffic on computer
and publish logs from traffic captured to **Apache Kafka** (A Distributed Streaming Platform)

## Requirements
- [x] Java JDK 12+

## Installation & Run
```bash
java -jar CaptureNetworkPacket.jar
```

After Zookeeper, Kafka server and Proxy Server running then go to Proxy Setting and setup manual proxy setting to localhost:9999

To see message traffic publish on Kafka topic let go to **kafka_2.13-2.7.0** folder and run this bellow command
```bash
.\bin\windows\kafka-console-consumer.bat --topic capture_packet_topic --from-beginning --bootstrap-server localhost:9092
```

#### Port using
```bash
localhost:9200 - Kafka Server
localhost:2181 - Zookeeper
localhost:9999 - Proxy Server
```
---
**NOTE**

You have to store application in directory path without spacing
 
