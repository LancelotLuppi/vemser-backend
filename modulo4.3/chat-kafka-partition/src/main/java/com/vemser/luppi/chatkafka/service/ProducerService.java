package com.vemser.luppi.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.luppi.chatkafka.dto.MensagemDTO;
import com.vemser.luppi.chatkafka.enums.EnvioEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic.chat}")
    private String topico;

    public void enviarMensagemTopicos(MensagemDTO mensagemDTO, Set<EnvioEnum> particoes) throws JsonProcessingException {
        String stringMensagem = objectMapper.writeValueAsString(mensagemDTO);

        particoes.forEach(c -> enviarMensagem(stringMensagem, c.ordinal()));
    }


    public void enviarMensagem(String mensagem, Integer particao) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, particao);
        Message<String> stringMessage = stringMessageBuilder
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Erro ao publicar a seguinte msg no kafka: " + stringMessage);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info(mensagem);

            }
        });
    }
}
