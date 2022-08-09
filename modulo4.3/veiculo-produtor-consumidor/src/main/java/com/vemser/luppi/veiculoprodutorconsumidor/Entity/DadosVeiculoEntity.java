package com.vemser.luppi.veiculoprodutorconsumidor.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "dados_veiculo")
public class DadosVeiculoEntity {
    @Field("data_leitura")
    private LocalDateTime dataLeitura;
    @Field("velocidade")
    private Double velocidade;
    @Field("rotacao")
    private Integer rotacao;
    @Field("sensor_frenagem")
    private Boolean sensorFrenagem;
}
