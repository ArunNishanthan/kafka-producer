package com.arun.kafka.producer.controller;

import com.arun.kafka.producer.service.KafKaProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@AllArgsConstructor
@Slf4j
public class KafkaProducerController {
    private final KafKaProducerService producerService;

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestParam("message") String message, @RequestParam("topic") String topic)
    {
        producerService.sendMessage(message, topic);
        return ResponseEntity.ok("ok");
    }
}
