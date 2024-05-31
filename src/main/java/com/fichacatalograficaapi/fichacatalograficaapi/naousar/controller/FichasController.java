package com.fichacatalograficaapi.fichacatalograficaapi.naousar.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.naousar.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.naousar.service.CriadorFichaPdf;
import com.fichacatalograficaapi.fichacatalograficaapi.naousar.service.FichasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fichas")
public class FichasController {

    @Autowired
    private FichasService fichasService;

    @Autowired
    private CriadorFichaPdf criadorFichaPdf;

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
    public ResponseEntity<Void> salvar(@Valid @RequestBody Ficha ficha) {
        ficha = fichasService.salvar(ficha);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<InputStreamResource> baixarFicha(@PathVariable("id") Long id) throws FileNotFoundException {
        Ficha ficha = fichasService.buscar(id).get();
        String nomeArquivo = "ficha-" + ficha.getId() + ".pdf";
        criadorFichaPdf.criarFichaPdf(ficha, nomeArquivo);

        File arquivo = new File(nomeArquivo);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(arquivo));

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + nomeArquivo)
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(arquivo.length())
                .body(resource);
    }
}
