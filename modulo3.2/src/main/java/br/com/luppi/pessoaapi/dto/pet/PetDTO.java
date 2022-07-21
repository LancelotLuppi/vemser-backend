package br.com.luppi.pessoaapi.dto.pet;

import br.com.luppi.pessoaapi.dto.pet.PetCreateDTO;
import lombok.Data;

@Data
public class PetDTO extends PetCreateDTO {
    private Integer idPet;

}
