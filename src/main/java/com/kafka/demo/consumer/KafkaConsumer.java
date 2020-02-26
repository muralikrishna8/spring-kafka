package com.kafka.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test-topic", groupId = "bar", containerFactory = "filterKafkaListenerContainerFactory")
    public void listener(String in) {
        logger.info("another class Received message is = " + in);
    }
}
