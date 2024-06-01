package com.fichacatalograficaapi.fichacatalograficaapi.application.gateways;

import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;

public interface CriadorFichaPdf {
    byte[] criarPdf(Ficha ficha, String caminhoDoArquivo);
}
