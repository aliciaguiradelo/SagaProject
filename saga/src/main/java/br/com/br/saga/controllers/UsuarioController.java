package br.com.br.saga.controllers;

import br.com.br.saga.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
public class UsuarioController {
    @GetMapping("/usuarios")
    public Usuario listAll(){
        return new Usuario(1L,"arthur.foschiani@outlook.com", "Arthur Foschiani", "123@a", LocalDate.of(2002, Month.DECEMBER, 21));
    }

}
