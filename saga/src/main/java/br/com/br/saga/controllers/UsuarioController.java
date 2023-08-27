package br.com.br.saga.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.saga.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    Logger log = LoggerFactory.getLogger(getClass());
    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/usuarios")
    public List<Usuario> Listar() {
        return usuarios;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> Cadastrar(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario - " + usuario);
        usuario.setId(usuarios.size() + 1L);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> BuscarPorId(@PathVariable Long id) {
        log.info("mostrar usuario com id - " + id);
        var usuarioEncontrado = usuarios
                .stream()
                .filter((usuario) -> usuario.getId().equals(id))
                .findFirst();

        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> Deletar(@PathVariable Long id) {
        log.info("apagando usuario com id - " + id);
        var usuarioEncontrado = usuarios
                .stream()
                .filter((usuario) -> usuario.getId().equals(id))
                .findFirst();

        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuarios.remove(usuarioEncontrado.get());
        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> Atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("atualizando usuario com id - " + id);
        var usuarioEncontrado = usuarios
                .stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst();

        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarios.remove(usuarioEncontrado.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.ok(usuario);
    }
}
