package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.EnderecoDTO;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                              @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>>  list() {
        return ResponseEntity.ok(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listByAddressId(@PathVariable("idEndereco") Integer id) throws  RegraDeNegocioException{
        return ResponseEntity.ok(enderecoService.listByAddressId(id));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>>  listByPersonId(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.listByPersonId(id));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> uptade(@PathVariable("idEndereco") Integer id,
                                 @RequestBody @Valid EnderecoCreateDTO enderecoAtualizado) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizado));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }

}
