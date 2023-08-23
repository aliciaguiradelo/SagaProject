package br.com.br.saga.controllers;

import br.com.br.saga.model.CategoriaFilme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaFilmesController {

    @GetMapping("/categorias")
    public CategoriaFilme listAll(){
        return new CategoriaFilme(1L, "aventura");
    }
}
