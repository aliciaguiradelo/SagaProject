package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.CategoriaFilme;
import br.com.br.saga.repository.CategoriaFilmeRepository;

import java.util.List;

@RestController
public class CategoriaFilmesController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CategoriaFilmeRepository repository;

    @GetMapping("/categorias")
    public List<CategoriaFilme> Listar() {
        return repository.findAll();
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaFilme> Cadastrar(@RequestBody CategoriaFilme categoria) {
        log.info("cadastrando categoria - " + categoria);
        repository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaFilme> BuscarPorId(@PathVariable Long id) {
        log.info("mostrar categoria com id - " + id);

        return ResponseEntity.ok(getCategoria(id));

    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Object> Deletar(@PathVariable Long id) {
        log.info("apagando categoria com id - " + id);
        
        repository.delete(getCategoria(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaFilme> Atualizar (@PathVariable Long id, @RequestBody CategoriaFilme categoria) {
        log.info("atualizando categoria com id - " + id);
        
        getCategoria(id);

        categoria.setId(id);
        repository.save(categoria);

        return ResponseEntity.ok(categoria);
    }

    private CategoriaFilme getCategoria(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }
}