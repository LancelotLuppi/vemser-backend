package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.dto.UsuarioDTO;
import br.com.luppi.pessoaapi.dto.login.LoginDTO;
import br.com.luppi.pessoaapi.dto.login.LoginReturnDTO;
import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginReturnDTO saveUser(LoginDTO login) throws RegraDeNegocioException {

        if(usuarioRepository.findByLogin(login.getLogin()).isPresent()) {
            throw new RegraDeNegocioException("Esse nome de usuário já existe!");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(login.getSenha());

        UsuarioEntity userCriado = new UsuarioEntity();
        userCriado.setLogin(login.getLogin());
        userCriado.setSenha(encodedPassword);
        usuarioRepository.save(userCriado);

        LoginReturnDTO loginRetorno = new LoginReturnDTO();
        loginRetorno.setUsername(userCriado.getUsername());
        return loginRetorno;
    }

    public UsuarioDTO getLoggedUser() throws EntidadeNaoEncontradaException {
        return returnDTO(findById(getIdLoggedUser()));
    }

    public Integer getIdLoggedUser() {
        return (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public UsuarioEntity findById(Integer idUsuario) throws EntidadeNaoEncontradaException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow( () -> new EntidadeNaoEncontradaException("Usuário não encontrado!"));
    }

    public UsuarioDTO returnDTO(UsuarioEntity entity) {
        return objectMapper.convertValue(entity, UsuarioDTO.class);
    }
}
