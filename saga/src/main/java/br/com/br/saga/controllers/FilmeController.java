package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.Filme;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmeController {

    List<Filme> filmes = new ArrayList<>();

    Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping("/filmes")
    public List<Filme> index () {
        return filmes;
    }

    @PostMapping("/filmes")
    public ResponseEntity<Object> create(@RequestBody Filme filme){
        log.info("cadastrando filme - " + filme);
        filme.setId(filmes.size() + 1L);
        filmes.add(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<Filme> show(@PathVariable Long id) {
        log.info("mostrar filme com id - " + id);
        var filmeEncontrado = filmes
                .stream()
                .filter((filme) -> filme.getId().equals(id))
                .findFirst();

        if (filmeEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(filmeEncontrado.get());
        }
    }

        @DeleteMapping("/filmes/{id}")
        public ResponseEntity<Object> destroy(@PathVariable Long id){
            log.info("apagando filme com id - " + id);
            var filmeEncontrado = filmes
                    .stream()
                    .filter( (filme) -> filme.getId().equals(id))
                    .findFirst();

            if (filmeEncontrado.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            filmes.remove(filmeEncontrado.get());
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/filmes/{id}")
        public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme){
            log.info("atualizando filme com id - " + id);
            var filmeEncontrado = filmes
                    .stream()
                    .filter((c) -> c.getId().equals(id))
                    .findFirst();

            if (filmeEncontrado.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            filmes.remove(filmeEncontrado.get());
            filme.setId(id);
            filmes.add(filme);

            return ResponseEntity.ok(filme);

        }





}
