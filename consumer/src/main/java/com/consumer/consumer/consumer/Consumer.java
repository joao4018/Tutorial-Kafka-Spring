package com.consumer.consumer.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "${topic.kafka-tutorial}", groupId = "123")
    public void consume(String message) {
        log.info("Mensagem Lida do kafka " + message);
    }
}
