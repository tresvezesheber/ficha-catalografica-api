package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.FichasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FichasController {

    @Autowired
    private FichasRepository fichasRepository;

    @RequestMapping(value = "/fichas", method = RequestMethod.GET)
    public List<Ficha> listar() {
        return fichasRepository.findAll();
    }
}
