package br.com.luppi.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    private Integer idPessoa;

    @Schema(description = "Nome da pessoa")
    @NotBlank
    private String nome;

    @Schema(description = "AAAA-MM-DD")
    @Past
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "CPF válido")
    @CPF
    private String cpf;

    @Schema(description = "seuEmail@dominio")
    @Email
    private String email;
}
