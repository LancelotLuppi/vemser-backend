package com.vemser.luppi.veiculoprodutorconsumidor.repository;

import com.vemser.luppi.veiculoprodutorconsumidor.Entity.DadosVeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosVeiculoRepository extends MongoRepository<DadosVeiculoEntity, Integer> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $velocidade }}}" })
    Double avgVelocidade();

}
