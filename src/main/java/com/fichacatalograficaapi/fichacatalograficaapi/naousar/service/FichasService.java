package com.fichacatalograficaapi.fichacatalograficaapi.naousar.service;

import com.fichacatalograficaapi.fichacatalograficaapi.naousar.model.Ficha;
import com.fichacatalograficaapi.fichacatalograficaapi.naousar.service.exceptions.FichaNaoEncontradaException;
import com.fichacatalograficaapi.fichacatalograficaapi.naousar.repository.FichasRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return fichasRepository.save(ficha);
    }
}
