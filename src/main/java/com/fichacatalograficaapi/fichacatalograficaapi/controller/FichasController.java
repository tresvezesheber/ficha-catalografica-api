package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.service.FichasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fichas")
public class FichasController {

    @Autowired
    private FichasService fichasService;

    @GetMapping
    public List<Ficha> listar() {
        return fichasService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        Optional<Ficha> ficha = fichasService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(ficha);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Ficha ficha) {
        ficha = fichasService.salvar(ficha);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        fichasService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Ficha ficha, @PathVariable("id") Long id) {
        ficha.setId(id);
        fichasService.atualizar(ficha);
        return ResponseEntity.noContent().build();
    }

}
