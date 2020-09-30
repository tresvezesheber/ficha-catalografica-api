package com.fichacatalograficaapi.fichacatalograficaapi.repository;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Curso, Long> {
}
