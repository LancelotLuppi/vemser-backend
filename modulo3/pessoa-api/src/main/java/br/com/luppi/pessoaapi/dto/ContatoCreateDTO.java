package br.com.luppi.pessoaapi.dto;

import br.com.luppi.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    @Schema(description = "Indentificador do dono de contato")
    private Integer idPessoa;

    @NotNull(message = "Tipo do contato nao pode ser nulo")
    private TipoContato tipoContato;
    @Size(min=3, max=13)

    @Schema(description = "Permitido caracteres especiais: ( )")
    @NotBlank(message = "Numero nao pode ser nulo ou em branco")
    private String telefone;
    @NotBlank(message = "Descricao nao pode ser nulo ou em branco")
    private String descricao;
}
