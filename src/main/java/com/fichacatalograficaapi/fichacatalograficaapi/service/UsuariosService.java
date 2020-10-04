package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Usuario;
import com.fichacatalograficaapi.fichacatalograficaapi.repository.UsuariosRepository;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuario> listar() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuario> buscar(Long id) {
        Optional<Usuario> usuario = usuariosRepository.findById(id);

        if (!usuario.isPresent()) {
            throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado.");
        }
        return usuario;
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setId(null);
        return usuariosRepository.save(usuario);
    }

    public void atualizar(Usuario usuario) {
        verificarExistencia(usuario);
        usuariosRepository.save(usuario);
    }

    private void verificarExistencia(Usuario usuario) {
        buscar(usuario.getId());
    }

    public void deletar(Long id) {
        try {
            usuariosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado.");
        }
    }
}
