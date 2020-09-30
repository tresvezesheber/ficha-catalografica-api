package com.fichacatalograficaapi.fichacatalograficaapi.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FichasController {

    @RequestMapping(value = "/fichas", method = RequestMethod.GET)
    public List<Ficha> listar() {
        Ficha ficha_1 = new Ficha("Heber Soares");
        Ficha ficha_2 = new Ficha("Desenv2");

        Ficha[] fichas = {ficha_1, ficha_2};
        return Arrays.asList(fichas);
    }
}
