package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.entity.Endereco;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
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


    public Endereco create(Integer id, Endereco endereco) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.returnPersonById(id);
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        return enderecoRepository.update(enderecoRecuperado, enderecoAtualizado);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listByPersonId(Integer id) throws RegraDeNegocioException {
        pessoaService.verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByAddressId(Integer id) throws RegraDeNegocioException {
        verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    //Uteis-------------------------------------------
    private Endereco recuperarEnderecoPorIdEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado"));
    }

    private void verificarId(Integer id) throws RegraDeNegocioException {
        enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException(("ID do endereco invalido ou inexistente")));
    }
}
