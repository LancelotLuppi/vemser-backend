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

    @Schema(description = "Permitido caracteres especiais: (DDD) 00000-0000")
    @NotBlank(message = "Numero nao pode ser nulo ou em branco")
    private String telefone;

    @Schema(description = "Maiores detalhes sobre o contato")
    @NotBlank(message = "Descricao nao pode ser nulo ou em branco")
    private String descricao;
}
