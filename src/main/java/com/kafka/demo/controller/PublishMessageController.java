package com.kafka.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PublishMessageController {
    private static final Logger logger = LoggerFactory.getLogger(PublishMessageController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/send", consumes = "application/json")
    @ResponseBody
    public String publishMessage(@RequestBody Map<String, String> value) {
        String message = value.get("message");

        logger.info("Received a request with param value = " + message);

        kafkaTemplate.send("test-topic", message);

        return "published message is: " + message;
    }
}
