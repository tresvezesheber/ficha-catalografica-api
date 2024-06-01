package com.fichacatalograficaapi.fichacatalograficaapi.application.usecases;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.RepositorioDeFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

import java.util.List;

public class ListarFichas {

    private final RepositorioDeFicha repositorioDeFicha;

    public ListarFichas(RepositorioDeFicha repositorioDeFicha) {
        this.repositorioDeFicha = repositorioDeFicha;
    }

    public List<Ficha> listarFichas() {
        return repositorioDeFicha.listar();
    }
}
