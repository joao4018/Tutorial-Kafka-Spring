package com.producer.producer.controller;

import com.producer.producer.request.MessageRequestBody;
import com.producer.producer.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProducerController  {

    @Autowired
    private final ProducerService producerService;


    @PostMapping(path = "/enviarMensagem")
    @Operation(summary = "Enviar uma nova mensagem ao Kafka")
    public ResponseEntity enviarMensagem(@RequestBody @Valid MessageRequestBody messageRequestBody) {
        producerService.enviarMensagemKafka(messageRequestBody.getMensagem());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
