package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.Favorito;
import br.com.br.saga.repository.FavoritoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FavoritoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    FavoritoRepository repository;

    @GetMapping("/favoritos")
    public List<Favorito> Listar() {
        return repository.findAll();
    }

    @PostMapping("/favoritos")
    public ResponseEntity<Favorito> Cadastrar(@RequestBody Favorito favorito) {
        log.info("cadastrando favorito - " + favorito);
        repository.save(favorito);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }

    @GetMapping("/favoritos/{id}")
    public ResponseEntity<Favorito> BuscarPorId(@PathVariable Long id) {
        log.info("mostrar favorito com id - " + id);

        return ResponseEntity.ok(getFavorito(id));
    }

    @DeleteMapping("/favoritos/{id}")
    public ResponseEntity<Object> Deletar(@PathVariable Long id) {
        log.info("apagando favorito com id - " + id);
        repository.delete(getFavorito(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/favoritos/{id}")
    public ResponseEntity<Favorito> Atualizar(@PathVariable Long id, @RequestBody Favorito favorito) {
        log.info("atualizando favorito com id - " + id);
        getFavorito(id);

        favorito.setId(id);
        repository.save(favorito);

        return ResponseEntity.ok(favorito);
    }

    private Favorito getFavorito(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }
}
