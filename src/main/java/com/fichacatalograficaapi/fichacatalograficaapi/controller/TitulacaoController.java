package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Titulacao;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.TitulacoesRepository;
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
    private TitulacoesRepository titulacoesRepository;

    @GetMapping
    public ResponseEntity<List<Titulacao>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(titulacoesRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Titulacao titulacao) {
        titulacao = titulacoesRepository.save(titulacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(titulacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        Optional<Titulacao> titulacao = titulacoesRepository.findById(id);

        if (!titulacao.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(titulacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        try {
            titulacoesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody Titulacao titulacao, @PathVariable("id") Long id) {
        titulacao.setId(id);
        titulacoesRepository.save(titulacao);
    }
}
