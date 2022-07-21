package br.com.luppi.pessoaapi.service;


import br.com.luppi.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.luppi.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.luppi.pessoaapi.entity.EnderecoEntity;
import br.com.luppi.pessoaapi.entity.PessoaEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    private final String NOT_FOUND_MESSAGE = "{idEndereco} nao encontrado";


    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntity = pessoaService.returnPersonById(idPessoa);
        EnderecoEntity enderecoEntity = returnEntity(enderecoCreateDTO);
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        return retornarDTO(enderecoRepository.save(enderecoEntity));
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizadoDto) throws EntidadeNaoEncontradaException {
        verificarId(idEndereco);

        PessoaEntity pessoaAtualizada = pessoaService.returnPersonById(enderecoAtualizadoDto.getIdPessoa());
        EnderecoEntity enderecoAtualizado = returnEntity(enderecoAtualizadoDto);

        enderecoAtualizado.setIdEndereco(idEndereco);
        enderecoAtualizado.setPessoas(Set.of(pessoaAtualizada));

        EnderecoDTO retornoEndereco = retornarDTO(enderecoRepository.save(enderecoAtualizado));
        retornoEndereco.setIdPessoa(enderecoAtualizadoDto.getIdPessoa());
        return retornoEndereco;
    }

    public void delete(Integer id) throws EntidadeNaoEncontradaException {
        EnderecoEntity enderecoEntityRecuperado = recuperarEnderecoPorIdEndereco(id);
        enderecoRepository.delete(enderecoEntityRecuperado);
    }

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
