package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Curso;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.CursosRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.CursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    public List<Curso> listar() {
        return cursosRepository.findAll();
    }

    public Optional<Curso> buscar(Long id) {
        Optional<Curso> curso = cursosRepository.findById(id);

        if (!curso.isPresent()) {
            throw new CursoNaoEncontradoException("O curso não pôde ser encontrado.");
        }
        return curso;
    }

    public Curso salvar(Curso curso) {
        curso.setId(null);
        return cursosRepository.save(curso);
    }

    public void atualizar(Curso curso) {
        verificarExistencia(curso);
        cursosRepository.save(curso);
    }

    private void verificarExistencia(Curso curso) {
        buscar(curso.getId());
    }

    public void deletar(Long id) {
        try {
            cursosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CursoNaoEncontradoException("O curso não pôde ser encontrado.");
        }
    }
}
