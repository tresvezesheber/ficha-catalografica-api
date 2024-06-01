package com.fichacatalograficaapi.fichacatalograficaapi.infra.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.MonografiaTitulacao;

public record FichaDTO(
        String autor,
        String titulo,
        String subtitulo,
        String cidade,
        String ano,
        String numeroPaginaPre,
        String numeroPaginaTotal,
        Boolean ilustracao,
        Boolean bibliografia,
        Boolean anexo,
        MonografiaTitulacao monografiaTitulacao,
        String instituicao,
        String curso,
        String orientador,
        String coorientador,
        String palavrasChave
) {
}
