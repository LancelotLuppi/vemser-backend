package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.dto.pessoa.PessoaRelatorioDTO;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate date1, LocalDate date2);

    @Query(value = "select new br.com.luppi.pessoaapi.dto.pessoa.PessoaRelatorioDTO(" +
            " p.idPessoa, " +
            " p.nome, " +
            " p.email, " +
            " pety.nome, " +
            " ctt.telefone, " +
            " e.cep, " +
            " e.cidade, " +
            " e.estado, " +
            " e.pais" +
            ") " +
            " from PESSOA p " +
            " left join p.pet pety " +
            " left join p.contatos ctt " +
            " left join p.enderecos e " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaRelatorioDTO> listRelatorioPessoa(@Param("idPessoa") Integer idPessoa);
}
