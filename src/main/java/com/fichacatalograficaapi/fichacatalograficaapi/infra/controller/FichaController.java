package com.fichacatalograficaapi.fichacatalograficaapi.infra.controller;

import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.BuscarFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.CriarFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.ListarFichas;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichas")
public class FichaController {

    private final CriarFicha criarFicha;

    private final ListarFichas listarFichas;

    private final BuscarFicha buscarFicha;

    public FichaController(CriarFicha criarFicha, ListarFichas listarFichas, BuscarFicha buscarFicha) {
        this.criarFicha = criarFicha;
        this.listarFichas = listarFichas;
        this.buscarFicha = buscarFicha;
    }

    @GetMapping("/{id}")
    public FichaDTO buscarFicha(@PathVariable Long id) {
        Ficha fichaEncontrada = buscarFicha.buscarFicha(id);
        return new FichaDTO(fichaEncontrada.getAutor(), fichaEncontrada.getTitulo(), fichaEncontrada.getSubtitulo(), fichaEncontrada.getCidade(), fichaEncontrada.getAno(), fichaEncontrada.getNumeroPaginaPre(), fichaEncontrada.getNumeroPaginaTotal(), fichaEncontrada.getIlustracao(), fichaEncontrada.getBibliografia(), fichaEncontrada.getAnexo(), fichaEncontrada.getMonografiaTitulacao(), fichaEncontrada.getInstituicao(), fichaEncontrada.getCurso(), fichaEncontrada.getOrientador(), fichaEncontrada.getCoorientador(), fichaEncontrada.getPalavrasChave());
    }

    @PostMapping
    public FichaDTO cadastrarFicha(@RequestBody FichaDTO fichaDTO) {
        Ficha fichaSalva = criarFicha.cadastrarFicha(new Ficha(fichaDTO.autor(), fichaDTO.titulo(), fichaDTO.subtitulo(), fichaDTO.cidade(), fichaDTO.ano(), fichaDTO.numeroPaginaPre(), fichaDTO.numeroPaginaTotal(), fichaDTO.ilustracao(), fichaDTO.bibliografia(), fichaDTO.anexo(), fichaDTO.monografiaTitulacao(), fichaDTO.instituicao(), fichaDTO.curso(), fichaDTO.orientador(), fichaDTO.coorientador(), fichaDTO.palavrasChave()));
        return new FichaDTO(fichaSalva.getAutor(), fichaSalva.getTitulo(), fichaSalva.getSubtitulo(), fichaSalva.getCidade(), fichaSalva.getAno(), fichaSalva.getNumeroPaginaPre(), fichaSalva.getNumeroPaginaTotal(), fichaSalva.getIlustracao(), fichaSalva.getBibliografia(), fichaSalva.getAnexo(), fichaSalva.getMonografiaTitulacao(), fichaSalva.getInstituicao(), fichaSalva.getCurso(), fichaSalva.getOrientador(), fichaSalva.getCoorientador(), fichaSalva.getPalavrasChave());
    }

    @GetMapping
    public List<FichaDTO> listarFichas() {
        return listarFichas.listarFichas().stream().map(ficha -> new FichaDTO(ficha.getAutor(), ficha.getTitulo(), ficha.getSubtitulo(), ficha.getCidade(), ficha.getAno(), ficha.getNumeroPaginaPre(), ficha.getNumeroPaginaTotal(), ficha.getIlustracao(), ficha.getBibliografia(), ficha.getAnexo(), ficha.getMonografiaTitulacao(), ficha.getInstituicao(), ficha.getCurso(), ficha.getOrientador(), ficha.getCoorientador(), ficha.getPalavrasChave())).toList();
    }
}
