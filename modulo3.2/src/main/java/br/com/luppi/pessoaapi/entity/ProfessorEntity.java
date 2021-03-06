package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.entity.pk.ProfessorPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "PROFESSOR")
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private Double salario;
}
