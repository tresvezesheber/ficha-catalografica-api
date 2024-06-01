package com.fichacatalograficaapi.fichacatalograficaapi.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<FichaEntity, Long> {
}
