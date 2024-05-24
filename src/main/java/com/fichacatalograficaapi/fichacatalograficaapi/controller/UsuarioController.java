package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Usuario;
import com.fichacatalograficaapi.fichacatalograficaapi.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuariosService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody Usuario usuario) {
        usuario = usuariosService.salvar(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody Usuario usuario, @PathVariable("id") Long id) {
        usuario.setId(id);
        usuariosService.atualizar(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        usuariosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
