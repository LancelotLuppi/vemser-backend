package br.com.luppi.pessoaapi.service;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private  PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception {
        return pessoaRepository.create(pessoa);
    }
    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizada) throws Exception {
        Pessoa pessoaRecuperada = returnPersonById(id);
        return pessoaRepository.update(pessoaRecuperada, pessoaAtualizada);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = returnPersonById(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public void verificarId(Integer idPessoa) throws  Exception{
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception(("ID da pessoa invalido ou inexistente")));
    }

    public Pessoa returnPersonById(Integer id) throws Exception {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
    }
}
