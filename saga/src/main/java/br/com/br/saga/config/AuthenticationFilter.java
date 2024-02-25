package br.com.br.saga.config;

import br.com.br.saga.model.Usuario;
import br.com.br.saga.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Log4j2
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obter o token
        var token = getToken(request);
        log.info(token);

        //if existe token
        if(token != null){
            Usuario user = tokenService.valideToken(token);
            Authentication auth = user.toAuthentication();
            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        //chamar o próximo filtro
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        var header = request.getHeader("Authorization");
        log.info("Header = {}", header);

        if(header == null || !header.startsWith("Bearer ")) return null;

        var token = header.replace("Bearer ", "");

        return token;

    }

}