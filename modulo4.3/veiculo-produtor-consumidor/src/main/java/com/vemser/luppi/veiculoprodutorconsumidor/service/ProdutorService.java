package com.vemser.luppi.veiculoprodutorconsumidor.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.luppi.veiculoprodutorconsumidor.Entity.DadosVeiculoEntity;
import com.vemser.luppi.veiculoprodutorconsumidor.dto.DadosVeiculoDTO;
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

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic}")
    private String topico;


    public void enviarDadosVeiculo(DadosVeiculoDTO dto) throws JsonProcessingException {
        DadosVeiculoEntity dadosVeiculoEntity = objectMapper.convertValue(dto, DadosVeiculoEntity.class);
        dadosVeiculoEntity.setDataLeitura(LocalDateTime.now());
        String payload = objectMapper.writeValueAsString(dadosVeiculoEntity);

        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Mensagem enviada para o kafka com o texto: {} ", message);
            }
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar mensagem no kafka com o texto: {} ", message, ex);
            }
        });
    }
}
