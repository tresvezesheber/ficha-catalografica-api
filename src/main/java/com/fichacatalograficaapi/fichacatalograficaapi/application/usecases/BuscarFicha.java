package com.fichacatalograficaapi.fichacatalograficaapi.application.usecases;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.RepositorioDeFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

public class BuscarFicha {

    private final RepositorioDeFicha repositorioDeFicha;

    public BuscarFicha(RepositorioDeFicha repositorioDeFicha) {
        this.repositorioDeFicha = repositorioDeFicha;
    }

    public Ficha buscarFicha(Long id) {
        return repositorioDeFicha.buscar(id);
    }
}
