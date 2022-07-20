package br.com.luppi.pessoaapi.dto;

import lombok.Data;

@Data
public class PetDTO extends PetCreateDTO {
    private Integer idPet;
    private Integer idPessoa;
}
