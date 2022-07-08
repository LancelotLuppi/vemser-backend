package br.com.luppi.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;

    @NotBlank(message = "O nome nao pode ser nulo")
    private String nome;

    @Past
    @NotNull(message= "A data nao pode ser nula")
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

}
