package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.dto.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.EnderecoDTO;
import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
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
    @Autowired
    private EmailService emailService;

    private final String NOT_FOUND_MESSAGE = "{idEndereco} nao encontrado";


    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws EntidadeNaoEncontradaException {
//        PessoaEntity pessoaEntity = pessoaService.returnPersonById(id);
//        enderecoCreateDTO.setIdPessoa(id);
        EnderecoEntity enderecoEntity = returnEntity(enderecoCreateDTO);
        EnderecoDTO enderecoDto = retornarDTO(enderecoRepository.save(enderecoEntity));
//        emailService.sendCreateEnderecoEmail(pessoaEntity, enderecoEntity);
        return enderecoDto;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws EntidadeNaoEncontradaException {
        EnderecoEntity enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
//        enderecoRecuperado.setIdPessoa(enderecoCreateDTO.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoCreateDTO.getTipo());
        enderecoRecuperado.setLogradouro(enderecoCreateDTO.getLogradouro());
        enderecoRecuperado.setNumero(enderecoCreateDTO.getNumero());
        enderecoRecuperado.setComplemento(enderecoCreateDTO.getComplemento());
        enderecoRecuperado.setCep(enderecoCreateDTO.getCep());
        enderecoRecuperado.setCidade(enderecoCreateDTO.getCidade());
        enderecoRecuperado.setEstado(enderecoCreateDTO.getEstado());
        enderecoRecuperado.setPais(enderecoCreateDTO.getPais());
        EnderecoDTO dto = retornarDTO(enderecoRepository.save(enderecoRecuperado));

//        PessoaEntity pessoa = pessoaService.returnPersonById(enderecoRecuperado.getIdPessoa());
//        emailService.sendUpdateEnderecoEmail(pessoa, enderecoRecuperado);
        return dto;
    }

    public void delete(Integer id) throws EntidadeNaoEncontradaException, RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = recuperarEnderecoPorIdEndereco(id);
//        PessoaEntity pessoaEntity = pessoaService.returnPersonById(enderecoEntityRecuperado.getIdPessoa());
        enderecoRepository.delete(enderecoEntityRecuperado);
//        emailService.sendDeleteEnderecoEmail(pessoaEntity, enderecoEntityRecuperado);
    }

//    public List<EnderecoDTO> listByPersonId(Integer id) throws EntidadeNaoEncontradaException {
//        pessoaService.verificarId(id);
//        return enderecoRepository.findAll().stream()
//                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(id))
//                .map(this::retornarDTO)
//                .collect(Collectors.toList());
//    }

    public EnderecoDTO listByAddressId(Integer id) throws EntidadeNaoEncontradaException {
        verificarId(id);
        return enderecoRepository.findById(id).stream()
                .map(this::retornarDTO)
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    //Uteis-------------------------------------------
    public EnderecoEntity recuperarEnderecoPorIdEndereco(Integer id) throws EntidadeNaoEncontradaException {
        return enderecoRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    private void verificarId(Integer id) throws EntidadeNaoEncontradaException {
        enderecoRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public EnderecoEntity returnEntity(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, EnderecoEntity.class);
    }

    public EnderecoDTO retornarDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }
}
