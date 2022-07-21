package br.com.luppi.pessoaapi.dto.contato;

import br.com.luppi.pessoaapi.dto.contato.ContatoCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO {
    @Schema(description = "Identificador único do contato")
    private Integer idContato;
}
