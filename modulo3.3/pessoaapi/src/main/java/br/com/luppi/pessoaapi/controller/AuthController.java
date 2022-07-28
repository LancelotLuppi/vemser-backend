package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.dto.LoginDTO;
import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.exception.RegraDeNegocioException;
import br.com.luppi.pessoaapi.security.TokenService;
import br.com.luppi.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        Authentication authentication = authenticationManager.authenticate(userToken);

        Object usuarioLogado = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;

        return tokenService.generateToken(usuarioEntity);
    }

    @PostMapping("/create-user")
    public LoginDTO createUser(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {
        return usuarioService.saveUser(login);
    }
}