package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
        this.contatoService = new ContatoService();
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer id,
                          @RequestBody Contato contato) throws Exception {
        return contatoService.create(id, contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizado) throws Exception {
        return contatoService.update(id, contatoAtualizado);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPersonId(@PathVariable("idPessoa") Integer id) {
        return contatoService.listByPersonId(id);
    }
}
