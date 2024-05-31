package com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FichaTest {
    @Test
    public void naoDeveCadastrarFichaComAutorVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComTituloVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComCidadeVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComAnoVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComNumeroPaginasPreVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComNumeroPaginasTotalVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComInlustracaoNulo() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", null,
                        null, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }


    @Test
    public void naoDeveCadastrarFichaComBibliografiaNulo() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        null, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComAnexoNulo() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, null, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComInstituicaoVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComCursoVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComOrientadorVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "", "Chani Kynes", "dune, sand worm, ride"));
    }

    @Test
    public void naoDeveCadastrarFichaComPalavrasChaveVazio() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", ""));
    }

    @Test
    public void naoDeveCadastrarFichaSemOMinimoDePalavrasChave() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ficha("Lisan al Gaib", "How to Ride a Shai-Hulud", "The Big One", "Arrakis", "2024",
                        "12", "64", true,
                        true, true, MonografiaTitulacao.TCC_BACHAREL, "Fremen University",
                        "Chief Prophet", "Stilgar Ben Fifrawi", "Chani Kynes", "dune, sand worm"));
    }
}
