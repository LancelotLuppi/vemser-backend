package br.com.luppi.pessoaapi.dto.pessoa;

import br.com.luppi.pessoaapi.dto.contato.ContatoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaComContatoDTO extends PessoaDTO {
    @Schema(description = "lista de contatos atrelados com a pessoa, 1..n")
    private List<ContatoDTO> contatos;
}
