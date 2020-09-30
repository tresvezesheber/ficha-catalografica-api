package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.FichasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fichas")
public class FichasController {

    @Autowired
    private FichasRepository fichasRepository;

    @GetMapping
    public List<Ficha> listar() {
        return fichasRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Ficha ficha) {
        fichasRepository.save(ficha);
    }
}
