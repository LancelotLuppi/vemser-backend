package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.pet.PetCreateDTO;
import br.com.luppi.pessoaapi.dto.pet.PetDTO;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Validated
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> post(@PathVariable("idPessoa") Integer idPessoa , @RequestBody @Valid PetCreateDTO pet) throws EntidadeNaoEncontradaException, RegraDeNegocioException {
        return ResponseEntity.ok(petService.create(idPessoa ,pet));
    }

    @GetMapping()
    public ResponseEntity<List<PetDTO>> get() {
        return ResponseEntity.ok(petService.getAll());
    }
    @GetMapping("/byid")
    public ResponseEntity<PetDTO> getById(@RequestParam("IdPet") Integer idPet) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(petService.getPet(idPet));
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> put(@PathVariable("idPet") Integer idPet, @Valid @RequestBody PetCreateDTO petDto) throws EntidadeNaoEncontradaException, RegraDeNegocioException {
        return ResponseEntity.ok(petService.update(idPet, petDto));
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer idPet) throws EntidadeNaoEncontradaException {
        petService.delete(idPet);
    }
}
