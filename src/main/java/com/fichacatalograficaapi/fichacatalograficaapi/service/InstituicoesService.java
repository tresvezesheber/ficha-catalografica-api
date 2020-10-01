package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Instituicao;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.InstituicoesRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.InstituicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicoesService {

    @Autowired
    private InstituicoesRepository instituicoesRepository;

    public List<Instituicao> listar() {
        return instituicoesRepository.findAll();
    }

    public Optional<Instituicao> buscar(Long id) {
        Optional<Instituicao> instituicao = instituicoesRepository.findById(id);

        if (!instituicao.isPresent()) {
            throw new InstituicaoNaoEncontradaException("A instituição não pode ser encontrada.");
        }
        return instituicao;
    }

    public Instituicao salvar(Instituicao instituicao) {
        instituicao.setId(null);
        return instituicoesRepository.save(instituicao);
    }

    public void deletar(Long id) {
        try {
            instituicoesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new InstituicaoNaoEncontradaException("A instituição não pôde ser encontrada.");
        }
    }

    public void atualizar(Instituicao instituicao) {
        verificarExistencia(instituicao);
        instituicoesRepository.save(instituicao);
    }

    public void verificarExistencia(Instituicao instituicao) {
        buscar(instituicao.getId());
    }
}
