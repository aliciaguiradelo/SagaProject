package br.com.br.saga.service;

import br.com.br.saga.model.dto.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
@Service
public class TokenService {
    public Token generateToken(String email){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        var jwt = JWT.create()
                .withIssuer("moneyrench")
                .withSubject(email)
                .withExpiresAt(Instant.now().plus(10, ChronoUnit.MINUTES))
                .sign(alg);

        return new Token(jwt, "JWT", "Bearer");

    }
}
