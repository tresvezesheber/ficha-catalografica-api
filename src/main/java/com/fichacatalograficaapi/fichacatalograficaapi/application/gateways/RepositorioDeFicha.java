package com.fichacatalograficaapi.fichacatalograficaapi.application.gateways;

import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

import java.util.List;

public interface RepositorioDeFicha {
    Ficha salvar(Ficha ficha);

    Ficha buscar(Long id);

    List<Ficha> listar();
}
