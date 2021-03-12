package com.facebook.capturepacket.configuration;

public interface Constant {

    public interface kafkaConstant{
        String BOOTSTRAP_SERVER = "localhost:9092";
        String DEFAULT_TOPIC    = "capture_packet_topic";
    }

    public interface KafkaStartCommandLine{
        String ZOOKEEPER_FILE           = "\\kafka_2.13-2.7.0\\bin\\windows\\zookeeper-server-start.bat";
        String ZOOKEEPER_CONFIG_FILE    = "\\kafka_2.13-2.7.0\\config\\zookeeper.properties";
        String KAFKA_SERVER_FILE        = "\\kafka_2.13-2.7.0\\bin\\windows\\kafka-server-start.bat";
        String KAFKA_SERVER_CONFIG_FILE = "\\kafka_2.13-2.7.0\\config\\server.properties";
    }

    public interface SystemDefault{
        String USER_NAME    = System.getProperty("user.name");
        String CURRENT_DIR  = System.getProperty("user.dir");
    }

}
