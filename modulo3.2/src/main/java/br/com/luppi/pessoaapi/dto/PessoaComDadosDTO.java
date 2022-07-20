package br.com.luppi.pessoaapi.dto;

import lombok.Data;

@Data
public class PessoaComDadosDTO {
    private PessoaDTO pessoaDTO;
    private DadosPessoaisDTO dadosPessoaisDTO;
}
