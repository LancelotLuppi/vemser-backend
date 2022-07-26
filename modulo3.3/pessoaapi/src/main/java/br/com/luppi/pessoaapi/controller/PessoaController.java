package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.config.PropertiesReader;
import br.com.luppi.pessoaapi.documentation.PessoaDocumentation;
import br.com.luppi.pessoaapi.dto.pessoa.*;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import br.com.luppi.pessoaapi.service.EmailService;
import br.com.luppi.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
public class PessoaController implements PessoaDocumentation {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PropertiesReader propertiesReader;


    @PostMapping
    public ResponseEntity<PessoaDTO> post(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }


    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> get() {
        return ResponseEntity.ok(pessoaService.list());
    }


    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> put(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }


    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws EntidadeNaoEncontradaException {
        pessoaService.delete(id);
    }

    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>>  getByNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @GetMapping("/{cpf}/cpf")
    public ResponseEntity<PessoaDTO> getByCpf(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(pessoaService.returnByCpf(cpf));
    }

    @GetMapping("/data-nascimento")
    public ResponseEntity<List<PessoaDTO>> getBetweenDataNascimento(@RequestParam("data") LocalDate dtInicial, LocalDate dtFinal) {
        return ResponseEntity.ok(pessoaService.listByDataNascimento(dtInicial, dtFinal));
    }

    @GetMapping("/lista-com-contatos")
    public ResponseEntity<List<PessoaComContatoDTO>>  getWithContato(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaService.listWithContato(idPessoa));
    }

    @GetMapping("/lista-com-enderecos")
    public ResponseEntity<List<PessoaComEnderecoDTO>> getWithEndereco(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaService.listWithEndereco(idPessoa));
    }

    @GetMapping("/lista-com-pet")
    public ResponseEntity<List<PessoaComPetDTO>> getWithPet(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaService.listWithPet(idPessoa));
    }

    @GetMapping("/lista-completa")
    public ResponseEntity<List<PessoaCompletaDTO>> getComplete(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) {
        return ResponseEntity.ok(pessoaService.completeList(idPessoa));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<PessoaRelatorioDTO>> getRelatorio(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) {
        return ResponseEntity.ok(pessoaService.gerarRelatorio(idPessoa));
    }


    @Hidden
    @GetMapping("/ambiente")
    public String retornarPropertie() {
        return propertiesReader.getAmbiente();
    }

}
