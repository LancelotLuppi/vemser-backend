package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}
