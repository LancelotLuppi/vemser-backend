package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.entity.TipoContato;
import br.com.luppi.pessoaapi.service.PessoaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContatoRepository {

    //TODO adicionar verificadores para o idPessoa e idContato

    private static List<Contato> listaContatos = new ArrayList<>();
    
    public Contato create(Integer id, Contato contato) throws Exception {
        contato.setIdPessoa(id);
        listaContatos.add(contato);
        return contato;
    }
    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,Contato contatoAtualizado) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoRecuperado.setTelefone(contatoAtualizado.getTelefone());
        contatoRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByPersonId(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
    
//    public boolean verificarIdPessoa(Integer idPessoa) throws  Exception{
//        PessoaService pessoaService = new PessoaService();
//        pessoaService.list().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
//                .findFirst()
//                .orElseThrow(() -> new Exception(("Pessoa não encontrada")));
//
//        return true;
//    }
}
