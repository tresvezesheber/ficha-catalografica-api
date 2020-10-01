package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Titulacao;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.TitulacoesRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.TitulacaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitulacoesService {

    @Autowired
    public TitulacoesRepository titulacoesRepository;

    public List<Titulacao> listar() {
        return titulacoesRepository.findAll();
    }

    public Optional<Titulacao> buscar(Long id) {
        Optional<Titulacao> titulacao = titulacoesRepository.findById(id);

        if (!titulacao.isPresent()) {
            throw new TitulacaoNaoEncontradaException("A titulação não pôde ser encontrada.");
        }
        return titulacao;
    }

    public Titulacao salvar(Titulacao titulacao) {
        titulacao.setId(null);
        return titulacoesRepository.save(titulacao);
    }

    public void deletar(Long id) {
        try {
            titulacoesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new TitulacaoNaoEncontradaException("A titulação não pôde ser encontrada.");
        }
    }

    public void atualizar(Titulacao titulacao) {
        verificarExistencia(titulacao);
        titulacoesRepository.save(titulacao);
    }

    private void verificarExistencia(Titulacao titulacao) {
        buscar(titulacao.getId());
    }
}
