package com.fichacatalograficaapi.fichacatalograficaapi.application.usecases;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.CriadorFichaPdf;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

public class CriarFichaPdf {

    public final CriadorFichaPdf criadorFichaPdf;

    public CriarFichaPdf(CriadorFichaPdf criadorFichaPdf) {
        this.criadorFichaPdf = criadorFichaPdf;
    }

    public byte[] criarFichaPdf(Ficha ficha, String path) {
        return criadorFichaPdf.criarPdf(ficha, path);
    }
}
