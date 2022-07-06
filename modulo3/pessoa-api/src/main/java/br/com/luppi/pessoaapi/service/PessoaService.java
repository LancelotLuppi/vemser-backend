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
        if(verificarNullPessoa(pessoa)) {
            throw new Exception("Pessoa e nome devem existir");
        }
        return pessoaRepository.create(pessoa);
    }
    public List<Pessoa> list(){
        return pessoaRepository.list();
    }
    public Pessoa update(Integer id, Pessoa pessoaAtualizada) throws  Exception {
        return pessoaRepository.update(id, pessoaAtualizada);
    }
    public void delete(Integer id) throws Exception{
        pessoaRepository.delete(id);
    }
    public List<Pessoa> listByName(String nome){
        return pessoaRepository.listByName(nome);
    }

    public boolean verificarNullPessoa(Pessoa pessoa) {
        return (pessoa != null && StringUtils.isBlank(pessoa.getNome())
                && StringUtils.isBlank(pessoa.getCpf())
                && pessoa.getDataNascimento() != null);
    }
}
