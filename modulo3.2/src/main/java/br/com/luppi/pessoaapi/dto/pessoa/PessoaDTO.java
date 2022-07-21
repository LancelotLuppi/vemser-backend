package br.com.luppi.pessoaapi.dto.pessoa;

import br.com.luppi.pessoaapi.dto.pessoa.PessoaCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "Identificador único da pessoa")
    private Integer idPessoa;
}
