package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.FichasRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.FichaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichasService {

    @Autowired
    private FichasRepository fichasRepository;

    public List<Ficha> listar() {
        return fichasRepository.findAll();
    }

    public Optional<Ficha> buscar(Long id) {
        Optional<Ficha> ficha = fichasRepository.findById(id);

        if (!ficha.isPresent()) {
            throw new FichaNaoEncontradaException("A ficha não pôde ser encontrada.");
        }
        return ficha;
    }

    public Ficha salvar(Ficha ficha) {
        ficha.setId(null);
        return fichasRepository.save(ficha);
    }

    public void atualizar(Ficha ficha) {
        verificarExistencia(ficha);
        fichasRepository.save(ficha);
    }

    private void verificarExistencia(Ficha ficha) {
        buscar(ficha.getId());
    }

    public void deletar(Long id) {
        try {
            fichasRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new FichaNaoEncontradaException("A ficha não pôde ser encontrada.");
        }
    }
}
