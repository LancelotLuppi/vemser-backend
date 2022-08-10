package com.vemser.luppi.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.luppi.chatkafka.dto.MensagemDTO;
import com.vemser.luppi.chatkafka.dto.MensagemEnvioDTO;
import com.vemser.luppi.chatkafka.enums.EnvioEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MensagemService {
    private final ProducerService producerService;
    private final ObjectMapper objectMapper;

    @Value("${kafka.user.name}")
    private String usuario;

    public void enviarMensagemTopicos(MensagemEnvioDTO envioDto, Set<EnvioEnum> chats) throws JsonProcessingException {
        String envio = envioDto.getMensagem();
        MensagemDTO mensagem = new MensagemDTO();
        mensagem.setMensagem(envio);
        mensagem.setUsuario(usuario);
        mensagem.setDataCriacao(LocalDateTime.now());

        producerService.enviarMensagemTopicos(mensagem, chats);
    }
}
