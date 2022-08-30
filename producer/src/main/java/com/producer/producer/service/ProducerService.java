package com.producer.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

//    private static final Logger log = LoggerFactory.getLogger(UserJob.class);


    @Value("${topic.kafka-tutorial}")
    private String batchKafka;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void enviarMensagemKafka(String mensagem) {

        log.info("Mensagem -> {}", mensagem);
        kafkaTemplate.send(batchKafka, String.valueOf(mensagem));


    }
}