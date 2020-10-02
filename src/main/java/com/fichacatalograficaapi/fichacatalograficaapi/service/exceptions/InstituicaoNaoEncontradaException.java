package com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions;

public class InstituicaoNaoEncontradaException extends RuntimeException {

    public InstituicaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public InstituicaoNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
