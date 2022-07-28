package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.dto.LoginDTO;
import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO saveUser(LoginDTO login) throws RegraDeNegocioException {

        if(usuarioRepository.findByLogin(login.getLogin()).isPresent()) {
            throw new RegraDeNegocioException("Esse nome de usuário já existe!");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncriptada = encoder.encode(login.getSenha());
        UsuarioEntity userCriado = new UsuarioEntity();
        userCriado.setLogin(login.getLogin());
        userCriado.setSenha(senhaEncriptada);
        usuarioRepository.save(userCriado);
        return login;
    }
}
