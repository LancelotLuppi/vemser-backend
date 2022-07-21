package br.com.luppi.pessoaapi.dto.pessoa;

import br.com.luppi.pessoaapi.dto.pet.PetDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaComPetDTO extends PessoaDTO {
    @Schema(description = "pet relacionado com a pessoa, 1..1")
    private PetDTO pet;
}
