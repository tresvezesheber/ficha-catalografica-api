package com.fichacatalograficaapi.fichacatalograficaapi.naousar.model;

public enum MonografiaTitulacao {

    DISSERTACAO_MESTRE("Dissertação / Mestre"),
    TCC_ESPECIALISTA("TCC / Especialista"),
    TCC_BACHAREL("TCC / Bacharel"),
    TESE_DOUTOR("Tese / Doutor"),
    TCC_LICENCIATURA("TCC / Licenciatura"),
    TESE_LIVRE_DOCENTE("Tese / Livre Docente"),
    TCC_TECNOLOGO("TCC / Tecnólogo");

    private String descricao;

    MonografiaTitulacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
