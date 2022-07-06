package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Integer id, Contato contato) throws Exception {
        return contatoRepository.create(id, contato);
    }
    public List<Contato> list(){
        return contatoRepository.list();
    }
    public Contato update(Integer id, Contato contatoAtualizado) throws Exception{
        return contatoRepository.update(id, contatoAtualizado);
    }
    public void delete(Integer id) throws Exception{
        contatoRepository.delete(id);
    }
    public List<Contato> listByPersonId(Integer id) {
        return contatoRepository.listByPersonId(id);
    }
}
