package com.facebook.capturepacket.configuration;

import com.facebook.capturepacket.model.NetworkPacket;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaConfig {

    private ProducerFactory<String, NetworkPacket> producerFactory(String IP_KAFKA_SERVER){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IP_KAFKA_SERVER);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    public KafkaTemplate<String, NetworkPacket> createKafkaTemplate(String IP_KAFKA_SERVER){
        log.info("Connect to kafka Server: "+IP_KAFKA_SERVER);
        return new KafkaTemplate<>(producerFactory(IP_KAFKA_SERVER));
    }

}
