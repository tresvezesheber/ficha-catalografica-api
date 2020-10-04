package com.fichacatalograficaapi.fichacatalograficaapi.repository;


import com.fichacatalograficaapi.fichacatalograficaapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository  extends JpaRepository<Usuario, Long> {
}
