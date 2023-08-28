package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.Favorito;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FavoritoController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Favorito> favoritos = new ArrayList<>();

    @GetMapping("/favoritos")
    public List<Favorito> Listar() {
        return favoritos;
    }

    @PostMapping("/favoritos")
    public ResponseEntity<Favorito> Cadastrar(@RequestBody Favorito favorito) {
        log.info("cadastrando favorito - " + favorito);
        favorito.setId(favoritos.size() + 1L);
        favoritos.add(favorito);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }

    @GetMapping("/favoritos/{id}")
    public ResponseEntity<Favorito> BuscarPorId(@PathVariable Long id) {
        log.info("mostrar favorito com id - " + id);
        var favoritoEncontrado = favoritos
                .stream()
                .filter((favorito) -> favorito.getId().equals(id))
                .findFirst();

        if (favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(favoritoEncontrado.get());
    }

    @DeleteMapping("/favoritos/{id}")
    public ResponseEntity<Object> Deletar(@PathVariable Long id) {
        log.info("apagando favorito com id - " + id);
        var favoritoEncontrado = favoritos
                .stream()
                .filter((favorito) -> favorito.getId().equals(id))
                .findFirst();

        if (favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        favoritos.remove(favoritoEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/favoritos/{id}")
    public ResponseEntity<Favorito> Atualizar(@PathVariable Long id, @RequestBody Favorito favorito) {
        log.info("atualizando favorito com id - " + id);
        var favoritoEncontrado = favoritos
                .stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst();

        if (favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        favoritos.remove(favoritoEncontrado.get());
        favorito.setId(id);
        favoritos.add(favorito);

        return ResponseEntity.ok(favorito);
    }
}
