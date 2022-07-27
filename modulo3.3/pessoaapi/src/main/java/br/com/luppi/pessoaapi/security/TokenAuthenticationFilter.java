package br.com.luppi.pessoaapi.security;

import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final static String BEARER = "Bearer ";


    // Realiza a filtragem da requisição
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> optionalUserEntity = tokenService.isValid(token);

        autenticar(optionalUserEntity);

        filterChain.doFilter(request, response);
    }


    // Autentica o usuário recuperado através do token
    public void autenticar(Optional<UsuarioEntity> optional) {
        boolean usuarioEhValido = optional.isPresent();
        if(usuarioEhValido) {
            UsuarioEntity userEntity = optional.get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userEntity.getLogin(), null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }



    // Recupera o token do Header da requisição
    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null) {
            return null;
        }
        return token.replace(BEARER, "");
    }
}