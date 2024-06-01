package com.fichacatalograficaapi.fichacatalograficaapi.config;

import com.fichacatalograficaapi.fichacatalograficaapi.application.gateways.RepositorioDeFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.CriarFicha;
import com.fichacatalograficaapi.fichacatalograficaapi.application.usecases.ListarFichas;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.gateways.FichaEntityMapper;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.gateways.RepositorioDeFichaJpa;
import com.fichacatalograficaapi.fichacatalograficaapi.infra.persistence.FichaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FichaConfig {

    @Bean
    CriarFicha criarFicha(RepositorioDeFicha repositorioDeFicha) {
        return new CriarFicha(repositorioDeFicha);
    }

    @Bean
    ListarFichas listarFichas(RepositorioDeFicha repositorioDeFicha) {
        return new ListarFichas(repositorioDeFicha);
    }

    @Bean
    RepositorioDeFichaJpa repositorioDeFichaJpa(FichaRepository fichaRepository, FichaEntityMapper fichaEntityMapper) {
        return new RepositorioDeFichaJpa(fichaRepository, fichaEntityMapper);
    }

    @Bean
    FichaEntityMapper fichaEntityMapper() {
        return new FichaEntityMapper();
    }
}
