package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.Usuario;
import br.com.br.saga.repository.UsuarioRepository;

import java.util.List;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UsuarioRepository repository;

    @GetMapping("/usuarios")
    public List<Usuario> Listar() {
        return repository.findAll();
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> Cadastrar(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario - " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> BuscarPorId(@PathVariable Long id) {
        log.info("mostrar usuario com id - " + id);

        return ResponseEntity.ok(getUsuario(id));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> Deletar(@PathVariable Long id) {
        log.info("apagando usuario com id - " + id);

        repository.delete(getUsuario(id));
        
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> Atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("atualizando usuario com id - " + id);

        getUsuario(id);

        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuario(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }
}
