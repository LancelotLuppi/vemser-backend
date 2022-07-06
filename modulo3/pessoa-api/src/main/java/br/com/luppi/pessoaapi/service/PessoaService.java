package br.com.luppi.pessoaapi.service;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    private  PessoaRepository pessoaRepository;

    public PessoaService() {
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa){
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
}
