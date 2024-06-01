package com.fichacatalograficaapi.fichacatalograficaapi.infra.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.CriarFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fichas")
public class FichaController {

    private final CriarFicha criarFicha;

    public FichaController(CriarFicha criarFicha) {
        this.criarFicha = criarFicha;
    }

    @PostMapping
    public FichaDTO cadastrarFicha(@RequestBody FichaDTO fichaDTO) {
        Ficha fichaSalva = criarFicha.cadastrarFicha(new Ficha(fichaDTO.autor(), fichaDTO.titulo(), fichaDTO.subtitulo(), fichaDTO.cidade(), fichaDTO.ano(), fichaDTO.numeroPaginaPre(), fichaDTO.numeroPaginaTotal(), fichaDTO.ilustracao(), fichaDTO.bibliografia(), fichaDTO.anexo(), fichaDTO.monografiaTitulacao(), fichaDTO.instituicao(), fichaDTO.curso(), fichaDTO.orientador(), fichaDTO.coorientador(), fichaDTO.palavrasChave()));
        return new FichaDTO(fichaSalva.getAutor(), fichaSalva.getTitulo(), fichaSalva.getSubtitulo(), fichaSalva.getCidade(), fichaSalva.getAno(), fichaSalva.getNumeroPaginaPre(), fichaSalva.getNumeroPaginaTotal(), fichaSalva.getIlustracao(), fichaSalva.getBibliografia(), fichaSalva.getAnexo(), fichaSalva.getMonografiaTitulacao(), fichaSalva.getInstituicao(), fichaSalva.getCurso(), fichaSalva.getOrientador(), fichaSalva.getCoorientador(), fichaSalva.getPalavrasChave());
    }
}
