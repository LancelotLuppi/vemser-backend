package com.vemser.luppi.veiculoprodutorconsumidor.dto;

import lombok.Data;

@Data
public class DadosVeiculoDTO {
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
