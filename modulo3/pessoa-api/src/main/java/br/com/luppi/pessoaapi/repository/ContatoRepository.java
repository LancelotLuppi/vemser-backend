package br.com.luppi.pessoaapi.repository;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.service.PessoaService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {

    private PessoaService pessoaService;
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        this.pessoaService = new PessoaService();
    }

    //TODO adicionar verificadores para o idPessoa e idContato


    
    public Contato create(Integer id, Contato contato) throws Exception {
        verificarIdPessoa(id);
        contato.setIdPessoa(id);
        contato.setIdContato(COUNTER.incrementAndGet());
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

    public List<Contato> listByPersonId(Integer id) throws Exception {
        verificarIdPessoa(id);
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
    
    public void verificarIdPessoa(Integer idPessoa) throws  Exception{
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception(("ID da pessoa invalido ou inexistente")));
    }
}
