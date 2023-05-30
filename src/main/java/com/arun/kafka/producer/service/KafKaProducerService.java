package com.arun.kafka.producer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafKaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, String topic)
    {
        log.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(topic, message);
    }
}
