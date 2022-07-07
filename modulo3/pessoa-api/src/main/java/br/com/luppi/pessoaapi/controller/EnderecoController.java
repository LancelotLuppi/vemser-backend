package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.Endereco;
import br.com.luppi.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer id,
                           @RequestBody Endereco endereco) throws  Exception {
        return enderecoService.create(id, endereco);
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
    public List<Endereco> listByPersonId(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.listByPersonId(id);
    }

    @PutMapping("/{idEndereco}")
    public Endereco uptade(@PathVariable("idEndereco") Integer id,
                            @RequestBody Endereco enderecoAtualizado) throws Exception {
        return enderecoService.update(id, enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
