package com.fichacatalograficaapi.fichacatalograficaapi.naousar.service.exceptions;

public class FichaNaoEncontradaException extends RuntimeException {

    public FichaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public FichaNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
