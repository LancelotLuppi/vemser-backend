package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.LoginDTO;
import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.security.TokenService;
import br.com.luppi.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> userOptional = usuarioService.findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if(userOptional.isPresent()) {
            return tokenService.generateToken(userOptional.get());
        }
        throw new RegraDeNegocioException("Usuario ou senha invalidos!");
    }
}