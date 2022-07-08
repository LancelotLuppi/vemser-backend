package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer id,
                                 @RequestBody @Valid Contato contato) throws Exception {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                          @RequestBody @Valid Contato contatoAtualizado) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizado));
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPersonId(@PathVariable("idPessoa") Integer id) throws Exception {
        return contatoService.listByPersonId(id);
    }
}
