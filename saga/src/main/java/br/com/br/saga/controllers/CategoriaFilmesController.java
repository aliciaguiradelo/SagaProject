package br.com.br.saga.controllers;

import br.com.br.saga.model.CategoriaFilme;
import br.com.br.saga.model.Filme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaFilmesController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<CategoriaFilme> categorias = new ArrayList<>();

    @GetMapping("/categorias")
    public List<CategoriaFilme> index() {
        return categorias;
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaFilme> create(@RequestBody CategoriaFilme categoria){
        log.info("cadastrando categoria - " + categoria);
        categoria.setId(categorias.size() + 1L);
        categorias.add(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaFilme> show(@PathVariable Long id) {
        log.info("mostrar categoria com id - " + id);
        var categoriaEncontrada = categorias
                .stream()
                .filter((categoria) -> categoria.getId().equals(id))
                .findFirst();

        if (categoriaEncontrada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoriaEncontrada.get());

    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando categoria com id - " + id);
        var categoriaEncontrada = categorias
                .stream()
                .filter( (categoria) -> categoria.getId().equals(id))
                .findFirst();

        if (categoriaEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        categorias.remove(categoriaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaFilme> update(@PathVariable Long id, @RequestBody CategoriaFilme categoria ){
        log.info("atualizando categoria com id - " + id);
        var categoriaEncontrada = categorias
                .stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst();

        if (categoriaEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        categorias.remove(categoriaEncontrada.get());
        categoria.setId(id);
        categorias.add(categoria);

        return ResponseEntity.ok(categoria);

    }

}