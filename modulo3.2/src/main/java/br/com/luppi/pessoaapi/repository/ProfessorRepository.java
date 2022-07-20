package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.ProfessorEntity;
import br.com.luppi.pessoaapi.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
