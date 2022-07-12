package br.com.luppi.pessoaapi.dto;

import br.com.luppi.pessoaapi.enums.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @Schema(description = "Tipo do endereço")
    @NotNull(message = "Insira um tipo para o endereco")
    private TipoEndereco tipo;

    @Size(min=3, max=250)
    @NotBlank(message = "Informe um logradouro")
    private String logradouro;

    @NotNull(message = "Informe um numero")
    private Integer numero;

    @Schema(description = "CEP apenas números")
    @Size(min=8, max=8)
    @NotBlank(message = "Informe um CEP valido")
    private String cep;

    @Size(min=2, max=250)
    @NotBlank(message = "Informe uma cidade")
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

}
