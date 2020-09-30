package com.fichacatalograficaapi.fichacatalograficaapi.repository;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichasRepository extends JpaRepository<Ficha, Long> {
}
