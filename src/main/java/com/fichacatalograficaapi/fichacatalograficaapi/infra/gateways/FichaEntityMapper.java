package com.fichacatalograficaapi.fichacatalograficaapi.infra.gateways;

import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.persistence.FichaEntity;

public class FichaEntityMapper {

    public FichaEntity toEntity(Ficha ficha) {
        return new FichaEntity(ficha.getAutor(), ficha.getTitulo(), ficha.getSubtitulo(), ficha.getCidade(), ficha.getAno(), ficha.getNumeroPaginaPre(), ficha.getNumeroPaginaTotal(), ficha.getIlustracao(), ficha.getBibliografia(), ficha.getAnexo(), ficha.getMonografiaTitulacao(), ficha.getInstituicao(), ficha.getCurso(), ficha.getOrientador(), ficha.getCoorientador(), ficha.getPalavrasChave());
    }

    public Ficha toDomain(FichaEntity fichaEntity) {
        return new Ficha(fichaEntity.getAutor(), fichaEntity.getTitulo(), fichaEntity.getSubtitulo(), fichaEntity.getCidade(), fichaEntity.getAno(), fichaEntity.getNumeroPaginaPre(), fichaEntity.getNumeroPaginaTotal(), fichaEntity.getIlustracao(), fichaEntity.getBibliografia(), fichaEntity.getAnexo(), fichaEntity.getMonografiaTitulacao(), fichaEntity.getInstituicao(), fichaEntity.getCurso(), fichaEntity.getOrientador(), fichaEntity.getCoorientador(), fichaEntity.getPalavrasChave());
    }
}
