package br.com.luppi.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

}
