package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.documentation.EnderecoDocumentation;
import br.com.luppi.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
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
public class EnderecoController implements EnderecoDocumentation {
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;



    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> post(Integer idPessoa, @RequestBody @Valid EnderecoCreateDTO endereco) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.create(idPessoa , endereco));
    }


    @GetMapping
    public ResponseEntity<List<EnderecoDTO>>  get() {
        return ResponseEntity.ok(enderecoService.list());
    }


    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> put(@PathVariable("idEndereco") Integer id,
                                 @RequestBody @Valid EnderecoCreateDTO enderecoAtualizado) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizado));
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> getByAddressId(@PathVariable("idEndereco") Integer id) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(enderecoService.listByAddressId(id));
    }


    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws EntidadeNaoEncontradaException {
        enderecoService.delete(id);
    }

    @GetMapping("/retorna-por-pais")
    public ResponseEntity<List<EnderecoEntity>> getEnderecosByPais(@RequestParam("País") String pais) {
        return ResponseEntity.ok(enderecoRepository.listEnderecoByPais(pais));
    }

    @GetMapping("/retorna-por-id-pessoa")
    public ResponseEntity<List<EnderecoEntity>> getEnderecoByIdPessoa(@RequestParam("idPessoa") Integer id) {
        return ResponseEntity.ok(enderecoRepository.listEnderecoByIdPessoa(id));
    }

}
