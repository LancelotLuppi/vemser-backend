package br.com.luppi.pessoaapi.security;

import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;


    // TODO Gera o token do usuário codificando seu user/senha
    public String generateToken(UsuarioEntity usuarioEntity) {
        String textoParaConverter = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        return Base64.getEncoder().encodeToString(textoParaConverter.getBytes());
    }



    // TODO Realiza a decodificação do token recebido e retorna um usuário através do user/senha
    public Optional<UsuarioEntity> isValid(String token) {
        if(token == null) {
            return Optional.empty();
        }
        byte[] bytesDecodificados = Base64.getUrlDecoder().decode(token);
        String decodificado = new String(bytesDecodificados);
        String[] split = decodificado.split(";");
        return usuarioService.findByLoginAndSenha(split[0], split[1]);
    }
}