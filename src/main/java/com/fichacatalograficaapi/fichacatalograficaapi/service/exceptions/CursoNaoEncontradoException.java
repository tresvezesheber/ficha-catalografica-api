package com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions;

public class CursoNaoEncontradoException extends RuntimeException {

    public CursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CursoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
