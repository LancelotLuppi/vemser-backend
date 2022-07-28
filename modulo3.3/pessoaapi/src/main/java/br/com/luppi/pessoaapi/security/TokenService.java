package br.com.luppi.pessoaapi.security;

import br.com.luppi.pessoaapi.entity.UsuarioEntity;
import br.com.luppi.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    // Gera o token do usuário codificando seu user/senha
    public String generateToken(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));


        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TokenAuthenticationFilter.BEARER + token;
    }



    // Realiza a decodificação do token recebido e retorna um usuário através do user/senha
    public UsernamePasswordAuthenticationToken isValid(String token) {
        if(token == null) {
            return null;
        }

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = body.get(Claims.ID, Integer.class);
        if(idUsuario != null) {
            return new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());
        }
        return null;
    }
}