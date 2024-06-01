package com.fichacatalograficaapi.fichacatalograficaapi.application.usecases;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.RepositorioDeFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

public class CriarFicha {

    private final RepositorioDeFicha repositorioDeFicha;

    public CriarFicha(RepositorioDeFicha repositorioDeFicha) {
        this.repositorioDeFicha = repositorioDeFicha;
    }

    public Ficha cadastrarFicha(Ficha ficha) {
        return repositorioDeFicha.salvar(ficha);
    }
}
