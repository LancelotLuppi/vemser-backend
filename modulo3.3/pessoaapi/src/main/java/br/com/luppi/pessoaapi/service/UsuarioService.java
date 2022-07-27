package br.com.luppi.pessoaapi.service;

import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
}
