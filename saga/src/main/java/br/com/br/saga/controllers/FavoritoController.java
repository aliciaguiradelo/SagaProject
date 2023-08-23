package br.com.br.saga.controllers;

import br.com.br.saga.model.Favorito;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritoController {

    @GetMapping()
    public Favorito listAll(){
        return new Favorito(1L,1L);
    }
}
