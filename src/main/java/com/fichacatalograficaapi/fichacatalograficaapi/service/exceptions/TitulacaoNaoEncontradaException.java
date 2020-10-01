package com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions;

public class TitulacaoNaoEncontradaException extends RuntimeException {

    public TitulacaoNaoEncontradaException (String mensagem) {
        super(mensagem);
    }

    public TitulacaoNaoEncontradaException (String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
