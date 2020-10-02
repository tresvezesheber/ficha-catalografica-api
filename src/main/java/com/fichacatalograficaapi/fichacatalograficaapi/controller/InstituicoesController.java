package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Instituicao;
import com.fichacatalograficaapi.fichacatalograficaapi.service.InstituicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instituicoes")
public class InstituicoesController {

    @Autowired
    private InstituicoesService instituicoesService;

    @GetMapping
    public ResponseEntity<List<Instituicao>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(instituicoesService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Instituicao> instituicao = instituicoesService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(instituicao);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Instituicao instituicao) {
        instituicao = instituicoesService.salvar(instituicao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instituicao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Instituicao instituicao, @PathVariable("id") Long id) {
        instituicao.setId(id);
        instituicoesService.atualizar(instituicao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        instituicoesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
