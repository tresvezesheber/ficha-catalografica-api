package com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha;

public class FabricaDeFicha {
    private Ficha ficha;

    public Ficha comCamposObrigatorios(String autor, String titulo, String cidade, String ano, String numeroPaginaPre, String numeroPaginaTotal, Boolean ilustracao, Boolean bibliografia, Boolean anexo, MonografiaTitulacao monografiaTitulacao, String instituicao, String curso, String orientador, String palavrasChave) {
        this.ficha = new Ficha(autor, titulo, "", cidade, ano, numeroPaginaPre, numeroPaginaTotal, ilustracao, bibliografia, anexo, monografiaTitulacao, instituicao, curso, orientador, "", palavrasChave);
        return this.ficha;
    }

    public Ficha incluirSubtitulo(String subtitulo) {
        this.ficha.setSubtitulo(subtitulo);
        return this.ficha;
    }

    public Ficha incluirCoorientador(String coorientador) {
        this.ficha.setCoorientador(coorientador);
        return this.ficha;
    }
}
