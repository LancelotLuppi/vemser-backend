package br.com.luppi.pessoaapi.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    private Integer idPessoa;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;

}
