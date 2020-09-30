package com.fichacatalograficaapi.fichacatalograficaapi.repository;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Titulacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitulacoesRepository extends JpaRepository<Titulacao, Long> {
}
