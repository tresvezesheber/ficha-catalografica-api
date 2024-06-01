package com.fichacatalograficaapi.fichacatalograficaapi.infra.gateways;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.RepositorioDeFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.persistence.FichaEntity;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.persistence.FichaRepository;

import java.util.List;

public class RepositorioDeFichaJpa implements RepositorioDeFicha {

    private final FichaRepository repositorio;

    private final FichaEntityMapper mapper;

    public RepositorioDeFichaJpa(FichaRepository repositorio, FichaEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Ficha salvar(Ficha ficha) {
        FichaEntity entity = mapper.toEntity(ficha);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Ficha buscar(Long id) {
        return mapper.toDomain(repositorio.findById(id).get());
    }

    @Override
    public List<Ficha> listar() {
        return repositorio.findAll().stream().map(mapper::toDomain).toList();
    }
}