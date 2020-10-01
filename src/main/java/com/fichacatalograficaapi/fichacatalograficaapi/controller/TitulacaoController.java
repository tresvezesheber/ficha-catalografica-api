package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Titulacao;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.TitulacoesRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.TitulacoesService;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.TitulacaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/titulacoes")
public class TitulacaoController {

    @Autowired
    private TitulacoesService titulacoesService;

    @GetMapping
    public ResponseEntity<List<Titulacao>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(titulacoesService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Titulacao titulacao) {
        titulacao = titulacoesService.salvar(titulacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(titulacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        Optional<Titulacao> titulacao = titulacoesService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(titulacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        titulacoesService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Titulacao titulacao, @PathVariable("id") Long id) {
        titulacao.setId(id);
        titulacoesService.atualizar(titulacao);
        return ResponseEntity.noContent().build();
    }
}
