package br.com.luppi.pessoaapi.service;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = returnPersonById(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }
    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = returnPersonById(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome){
        return pessoaRepository.listByName(nome);
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
