package com.luppi.kafka.produtorconsumidor.controller;

import com.luppi.kafka.produtorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-mensagem")
    public void enviarMensagemParaOTopico(String mensagem){
        produtorService.enviarMensagem(mensagem);
    }
}
