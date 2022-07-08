package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.repository.ContatoRepository;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ContatoRepository contatoRepository;


    public Contato create(Integer id, Contato contato) throws Exception {
        Pessoa pessoa = pessoaService.returnPersonById(id);
        contato.setIdPessoa(pessoa.getIdPessoa());
        return contatoRepository.create(contato);
    }
    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,Contato contatoAtualizado) throws Exception {
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        contatoRecuperado.setIdPessoa(contatoAtualizado.getIdPessoa());
        contatoRecuperado.setTelefone(contatoAtualizado.getTelefone());
        contatoRecuperado.setDescricao(contatoAtualizado.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        contatoRepository.list().remove(contatoRecuperado);
    }

    public List<Contato> listByPersonId(Integer id) throws Exception {
        pessoaService.verificarId(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }



    private Contato recuperarContatoPorIdContato(Integer id) throws Exception {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
    }
}
