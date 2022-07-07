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
        if(verificarCamposNulos(endereco)) {
            throw new Exception("Os campos nao podem ser nulos");
        }
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa nao encontrada"));
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado) throws Exception {
        if(verificarCamposNulos(enderecoAtualizado)) {
            throw new Exception("Os campos nao podem ser nulos");
        }
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRecuperado.setIdPessoa(enderecoAtualizado.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizado.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizado.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizado.getComplemento());
        enderecoRecuperado.setCidade(enderecoAtualizado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizado.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizado.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRepository.list().remove(enderecoRecuperado);
    }

    public List<Endereco> listByPersonId(Integer id) throws Exception {
        verificarIdPessoa(id);
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

    private void verificarIdPessoa(Integer idPessoa) throws  Exception{
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception(("ID da pessoa invalido ou inexistente")));
    }

    private boolean verificarCamposNulos(Endereco endereco) {
        return (endereco != null
                && (endereco.getIdPessoa() == null
                || endereco.getTipo() == null
                || endereco.getLogradouro() == null
                || endereco.getNumero() == null
                || endereco.getComplemento() == null
                || endereco.getCidade() == null
                || endereco.getEstado() == null
                || endereco.getPais() == null));
    }
}
