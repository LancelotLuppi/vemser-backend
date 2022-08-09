package com.vemser.luppi.veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.luppi.veiculoprodutorconsumidor.Entity.DadosVeiculoEntity;
import com.vemser.luppi.veiculoprodutorconsumidor.dto.DadosMediaDTO;
import com.vemser.luppi.veiculoprodutorconsumidor.dto.DadosVeiculoDTO;
import com.vemser.luppi.veiculoprodutorconsumidor.repository.DadosVeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {
    private final ObjectMapper objectMapper;
    private final MongoTemplate mongoTemplate;
    private final DadosVeiculoRepository dadosVeiculoRepository;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "sensorVeiculo")
    public void consumir(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        DadosVeiculoEntity entity = objectMapper.readValue(mensagem, DadosVeiculoEntity.class);
        mongoTemplate.save(entity, "dados_veiculo");
        log.info("###{consume} offset -> '{}' | key -> '{}' | Consumed Object message -> '{}' ", offset, key, mensagem);
    }

    public List<DadosVeiculoEntity> retornarDados() {
        return dadosVeiculoRepository.findAll();
    }

    public DadosMediaDTO retornarDadoDeMedia() {

        OptionalDouble mediaVelocidade = dadosVeiculoRepository.findAll().stream()
                .mapToDouble(DadosVeiculoEntity::getVelocidade).average();
        OptionalDouble rotacaoMedia = dadosVeiculoRepository.findAll().stream()
                .mapToDouble(DadosVeiculoEntity::getRotacao).average();
        Integer qntRegistro = dadosVeiculoRepository.findAll().size();

        DadosMediaDTO mediaDTO = new DadosMediaDTO();
        mediaDTO.setVelocidadeMedia(dadosVeiculoRepository.avgVelocidade());
        mediaDTO.setRotacaoMedia(rotacaoMedia.getAsDouble());
        mediaDTO.setQuantidadeLeituras(qntRegistro);
        return mediaDTO;
    }

}
