package br.com.luppi.pessoaapi.dto.pessoa;

import br.com.luppi.pessoaapi.dto.dados.DadosPessoaisDTO;
import lombok.Data;

@Data
public class PessoaComDadosDTO {
    private PessoaDTO pessoaDTO;
    private DadosPessoaisDTO dadosPessoaisDTO;
}
