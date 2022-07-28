package br.com.luppi.pessoaapi.security;

import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    protected final static String BEARER = "Bearer ";


    // Realiza a filtragem da requisição
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getTokenFromHeader(request);

        UsernamePasswordAuthenticationToken userToken = tokenService.isValid(token);

        SecurityContextHolder.getContext().setAuthentication(userToken);

        filterChain.doFilter(request, response);
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