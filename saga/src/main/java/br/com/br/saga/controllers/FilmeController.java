package br.com.br.saga.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.br.saga.model.Filme;

@RestController
public class FilmeController {
    
    @GetMapping("/filmes")
    public Filme listAll () {
        return new Filme(1, "Harry Potter", "Menino bruxo que foi para uma escola de mágia", "Não sei");
    }
}
