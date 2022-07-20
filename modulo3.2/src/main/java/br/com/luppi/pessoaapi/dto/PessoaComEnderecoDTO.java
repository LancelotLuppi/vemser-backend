package br.com.luppi.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaComEnderecoDTO extends PessoaDTO {
    @Schema(description = "lista de enderecos relacionados com a pessoa, n..n")
    private List<EnderecoDTO> enderecos;
}
