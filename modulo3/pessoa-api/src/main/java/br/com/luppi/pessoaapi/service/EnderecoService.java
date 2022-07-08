package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.entity.Endereco;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;


    public Endereco create(Integer id, Endereco endereco) throws Exception {
        Pessoa pessoa = pessoaService.returnPersonById(id);
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado) throws Exception {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        return enderecoRepository.update(enderecoRecuperado, enderecoAtualizado);
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listByPersonId(Integer id) throws Exception {
        pessoaService.verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByAddressId(Integer id) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    //Uteis-------------------------------------------
    private Endereco recuperarEnderecoPorIdEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco nao encontrado"));
    }
}
