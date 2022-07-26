package br.com.luppi.pessoaapi.dto.pessoa;

import br.com.luppi.pessoaapi.dto.contato.ContatoDTO;
import br.com.luppi.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.luppi.pessoaapi.dto.pet.PetDTO;
import br.com.luppi.pessoaapi.entity.ContatoEntity;
import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import br.com.luppi.pessoaapi.entity.PetEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCompletaDTO extends PessoaDTO {

    @Schema(description = "Pet da pessoa")
    private PetDTO pet;

    @Schema(description = "Contatos da pessoa")
    private List<ContatoDTO> contatos;

    @Schema(description = "Enderecos da pessoa")
    private List<EnderecoDTO> enderecos;
}
