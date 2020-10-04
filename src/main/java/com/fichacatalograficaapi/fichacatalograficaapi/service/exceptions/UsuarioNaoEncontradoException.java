package com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public UsuarioNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
