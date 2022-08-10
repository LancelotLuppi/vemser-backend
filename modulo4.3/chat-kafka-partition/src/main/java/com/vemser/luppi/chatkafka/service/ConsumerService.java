package com.vemser.luppi.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.luppi.chatkafka.dto.MensagemDTO;
import com.vemser.luppi.chatkafka.enums.EnvioEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.chat}",
            groupId = "${kafka.user.name}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat"
    )
    public void imprimirMensagem(@Payload String message,
                                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer particao,
                                       @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(message, MensagemDTO.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        if(particao == EnvioEnum.GERAL.ordinal()) {
            log.info(mensagemDTO.getDataCriacao().format(formatter) + " [" + mensagemDTO.getUsuario() + "]: " +
                    mensagemDTO.getMensagem());
        } else if(particao == EnvioEnum.GABRIEL.ordinal()) {
            log.info(mensagemDTO.getDataCriacao().format(formatter) + " [" + mensagemDTO.getUsuario() + "] (privado): " +
                    mensagemDTO.getMensagem());
        }
    }
}
