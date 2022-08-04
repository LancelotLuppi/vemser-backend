package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.ContatoEntity;
import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import br.com.luppi.pessoaapi.repository.ContatoRepository;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@AllArgsConstructor
public class PaginacaoController {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/contatos-order-descricao")
    public Page<ContatoEntity> getContatosOrderByDesc(Integer pagina, Integer quantidadeRegistros) {
        Sort ordenacao = Sort.by("descricao");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-order-cep")
    public Page<EnderecoEntity> getEnderecosOrderByCep(Integer pagina, Integer quantidadeRegistros) {
        Sort ordenacao = Sort.by("cep");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-order-pais")
    public Page<EnderecoEntity> getEnderecosOrderByPais(Integer pagina, Integer quantidadeRegistros) {
        Sort ordenacao = Sort.by("pais");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.findAll(pageable);
    }
}
