package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.dto.ContatoCreateDTO;
import br.com.luppi.pessoaapi.dto.ContatoDTO;
import br.com.luppi.pessoaapi.entity.Contato;
import br.com.luppi.pessoaapi.repository.ContatoRepository;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private ObjectMapper objectMapper;


    public ContatoDTO create(Integer id, ContatoCreateDTO contatoDto) throws Exception {
        pessoaService.verificarId(id);
        contatoDto.setIdPessoa(id);
        Contato contato = converterDTO(contatoDto);
        return retornarDTO(contatoRepository.create(contato));
    }
    public List<ContatoDTO> list(){
        return contatoRepository.list().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,ContatoCreateDTO contatoDto) throws Exception {
        Contato contatoAtualizado = converterDTO(contatoDto);
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        return retornarDTO(contatoRepository.update(contatoRecuperado, contatoAtualizado)) ;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = recuperarContatoPorIdContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<ContatoDTO> listByPersonId(Integer id) throws Exception {
        pessoaService.verificarId(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }



    // Uteis-----------------------------------------------------------------------

    private Contato recuperarContatoPorIdContato(Integer id) throws Exception {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
    }

    private Contato converterDTO(ContatoCreateDTO dto) {
        return objectMapper.convertValue(dto, Contato.class);
    }

    private ContatoDTO retornarDTO(Contato contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }
}
