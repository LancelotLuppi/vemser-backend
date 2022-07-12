package br.com.luppi.pessoaapi.service;


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
    @Autowired
    private EmailService emailService;


    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.returnPersonById(id);
        enderecoCreateDTO.setIdPessoa(id);
        Endereco endereco = returnEntity(enderecoCreateDTO);
        EnderecoDTO enderecoDto = retornarDTO(enderecoRepository.create(endereco));
        emailService.sendCreateEnderecoEmail(pessoa, endereco);
        return enderecoDto;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        Endereco enderecoAtualizado = returnEntity(enderecoCreateDTO);
        Pessoa pessoa = pessoaService.returnPersonById(enderecoAtualizado.getIdPessoa());
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        EnderecoDTO enderecoDto = retornarDTO(enderecoRepository.update(enderecoRecuperado, enderecoAtualizado));
        emailService.sendUpdateEnderecoEmail(pessoa, enderecoAtualizado);
        return enderecoDto;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = recuperarEnderecoPorIdEndereco(id);
        Pessoa pessoa = pessoaService.returnPersonById(enderecoRecuperado.getIdPessoa());
        enderecoRepository.delete(enderecoRecuperado);
        emailService.sendDeleteEnderecoEmail(pessoa, enderecoRecuperado);
    }

    public List<EnderecoDTO> listByPersonId(Integer id) throws RegraDeNegocioException {
        pessoaService.verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByAddressId(Integer id) throws RegraDeNegocioException {
        verificarId(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(this::retornarDTO)
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
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException(("ID do endereco invalido ou inexistente")));
    }

    public Endereco returnEntity(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, Endereco.class);
    }

    public EnderecoDTO retornarDTO(Endereco endereco) {
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }
}
