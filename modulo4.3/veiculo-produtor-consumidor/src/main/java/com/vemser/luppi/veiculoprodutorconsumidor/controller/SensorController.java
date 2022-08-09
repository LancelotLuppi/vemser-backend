package com.vemser.luppi.veiculoprodutorconsumidor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vemser.luppi.veiculoprodutorconsumidor.Entity.DadosVeiculoEntity;
import com.vemser.luppi.veiculoprodutorconsumidor.dto.DadosMediaDTO;
import com.vemser.luppi.veiculoprodutorconsumidor.dto.DadosVeiculoDTO;
import com.vemser.luppi.veiculoprodutorconsumidor.service.ConsumidorService;
import com.vemser.luppi.veiculoprodutorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {
    private final ProdutorService produtorService;
    private final ConsumidorService consumidorService;

    @PostMapping("/dados")
    public void enviarDadosSensor(DadosVeiculoDTO dadosVeiculoDTO) throws JsonProcessingException {
        produtorService.enviarDadosVeiculo(dadosVeiculoDTO);
    }

    @GetMapping("/dados")
    public List<DadosVeiculoEntity> retornarDados() {
        return consumidorService.retornarDados();
    }

    @GetMapping("/dados-media")
    public DadosMediaDTO retornarMediaLeituras() {
        return consumidorService.retornarDadoDeMedia();
    }
}
