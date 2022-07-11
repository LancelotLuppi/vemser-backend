package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.controller.EnderecoController;
import br.com.luppi.pessoaapi.dto.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.EnderecoDTO;
import br.com.luppi.pessoaapi.entity.Endereco;
import br.com.luppi.pessoaapi.entity.Pessoa;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
import br.com.luppi.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private ObjectMapper objectMapper;


    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoDTO) throws RegraDeNegocioException {
        pessoaService.verificarId(id);
        enderecoDTO.setIdPessoa(id);
        Endereco endereco = objectMapper.convertValue(enderecoDTO, Endereco.class);
        return objectMapper.convertValue(enderecoRepository.create(endereco), EnderecoDTO.class) ;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoDTO) throws RegraDeNegocioException {
        Endereco enderecoAtualizado = objectMapper.convertValue(enderecoDTO, Endereco.class);
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        return objectMapper.convertValue(enderecoRepository.update(enderecoRecuperado, enderecoAtualizado), EnderecoDTO.class) ;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<EnderecoDTO> listByPersonId(Integer id) throws RegraDeNegocioException {
        pessoaService.verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByAddressId(Integer id) throws RegraDeNegocioException {
        verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    //Uteis-------------------------------------------
    private Endereco recuperarEnderecoPorIdEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado"));
    }

    private void verificarId(Integer id) throws RegraDeNegocioException {
        enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException(("ID do endereco invalido ou inexistente")));
    }
}
