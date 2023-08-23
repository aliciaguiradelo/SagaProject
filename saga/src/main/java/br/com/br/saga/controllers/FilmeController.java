package br.com.br.saga.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.br.saga.model.Filme;

import java.time.LocalDate;
import java.time.Month;

@RestController
public class FilmeController {
    
    @GetMapping("/filmes")
    public Filme listAll () {
        return new Filme(1L, "Harry Potter", "Menino bruxo que foi para uma escola de mágia", "Não sei", "120", LocalDate.of(2001, Month.AUGUST,01), "http//www.image.com", 12, 2L);
    }
}
