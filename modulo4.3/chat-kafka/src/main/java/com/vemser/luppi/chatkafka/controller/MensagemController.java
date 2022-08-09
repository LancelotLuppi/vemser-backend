package com.vemser.luppi.chatkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vemser.luppi.chatkafka.dto.MensagemEnvioDTO;
import com.vemser.luppi.chatkafka.enums.ChatEnum;
import com.vemser.luppi.chatkafka.service.MensagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/mensagem")
@RequiredArgsConstructor
public class MensagemController {
    private final MensagemService mensagemService;

    @PostMapping("/global")
    public void enviarMensagemGlobal(MensagemEnvioDTO envio) throws JsonProcessingException {
        mensagemService.enviarMensagemGlobal(envio);
    }

    @PostMapping("/privado")
    public void enviarMensagemPrivada(MensagemEnvioDTO envio,
                                      @RequestParam("chats") Set<ChatEnum> chats) throws JsonProcessingException {
        mensagemService.enviarMensagemTopicos(envio, chats);
    }
}
