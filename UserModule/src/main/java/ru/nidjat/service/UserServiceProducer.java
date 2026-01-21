package ru.nidjat.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProducer {
    private static final String userTopic = "notification-topic";
    private final KafkaTemplate <String, String> kafkaTemplate;
    public UserServiceProducer (KafkaTemplate <String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }
    public void sendUserMessage (String message) {
        kafkaTemplate.send("notification-topic", message);

    }




}
