package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.Endereco;
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
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer id,
                           @RequestBody @Valid Endereco endereco) throws  Exception {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByAddressId(@PathVariable("idEndereco") Integer id) throws  Exception{
        return enderecoService.listByAddressId(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByPersonId(@PathVariable("idPessoa") Integer id) throws Exception {
        return enderecoService.listByPersonId(id);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> uptade(@PathVariable("idEndereco") Integer id,
                                 @RequestBody @Valid Endereco enderecoAtualizado) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizado));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
