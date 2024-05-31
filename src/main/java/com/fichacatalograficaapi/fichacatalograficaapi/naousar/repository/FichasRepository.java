package com.fichacatalograficaapi.fichacatalograficaapi.naousar.repository;

import com.fichacatalograficaapi.fichacatalograficaapi.naousar.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichasRepository extends JpaRepository<Ficha, Long> {
}
