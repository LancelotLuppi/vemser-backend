package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.dto.PetCreateDTO;
import br.com.luppi.pessoaapi.dto.PetDTO;
import br.com.luppi.pessoaapi.entity.PetEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public PetDTO create(Integer idPessoa , PetCreateDTO petDto) throws EntidadeNaoEncontradaException {
        PetEntity petEntity =  retornarEntity(petDto);
        petEntity.setPessoa(pessoaService.returnPersonById(idPessoa));
        PetDTO petCriado = retornarDTO(petRepository.save(petEntity));
        petCriado.setIdPessoa(idPessoa);
        return petCriado;
    }

    public PetDTO update(Integer id, PetCreateDTO petAtualizado) throws EntidadeNaoEncontradaException {
        PetEntity petRecuperado = retornarPorId(id);
        petRecuperado.setNome(petAtualizado.getNome());
        petRecuperado.setTipo(petAtualizado.getTipo());
        PetDTO retornoPet = retornarDTO(petRepository.save(petRecuperado));
        retornoPet.setIdPessoa(petRecuperado.getPessoa().getIdPessoa());
        return retornoPet;
    }

    public List<PetDTO> getAll() {
        return petRepository.findAll().stream()
                .map(petEntity -> {
                    PetDTO petDto = retornarDTO(petEntity);
                    petDto.setIdPessoa(petEntity.getPessoa().getIdPessoa());
                    return petDto;
                }).toList();
    }

    public PetDTO getPet(Integer idPet) throws EntidadeNaoEncontradaException {
        PetEntity petRecuperado = retornarPorId(idPet);
        PetDTO retornoPet = retornarDTO(petRecuperado);
        retornoPet.setIdPessoa(petRecuperado.getPessoa().getIdPessoa());
        return retornoPet;
    }

    public void delete(Integer idPet) throws EntidadeNaoEncontradaException {
        PetEntity petRecuperado = retornarPorId(idPet);
        petRepository.delete(petRecuperado);
    }


    //------------------------------------Auxiliares-------------------------------------
    public PetEntity retornarEntity(PetCreateDTO dto) {
        return objectMapper.convertValue(dto, PetEntity.class);
    }
    public PetDTO retornarDTO(PetEntity entity) {
        return objectMapper.convertValue(entity, PetDTO.class);
    }

    public PetEntity retornarPorId(Integer id) throws EntidadeNaoEncontradaException {
        return petRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("{idPet} não encontrado"));
    }
}
