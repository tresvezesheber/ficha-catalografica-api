package com.fichacatalograficaapi.fichacatalograficaapi.handler;

import com.fichacatalograficaapi.fichacatalograficaapi.model.ErroDetalhes;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.CursoNaoEncontradoException;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.FichaNaoEncontradaException;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.InstituicaoNaoEncontradaException;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.TitulacaoNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(TitulacaoNaoEncontradaException.class)
    public ResponseEntity<ErroDetalhes> handleTitulacaoNaoEncontradaException(TitulacaoNaoEncontradaException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("A titulação não pôde ser encontrada.");
        erroDetalhes.setStatus(404l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetalhes);
    }

    @ExceptionHandler(CursoNaoEncontradoException.class)
    public ResponseEntity<ErroDetalhes> handleCursoNaoEncontradoException(CursoNaoEncontradoException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("O curso não pôde ser encontrado.");
        erroDetalhes.setStatus(404l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetalhes);
    }

    @ExceptionHandler(FichaNaoEncontradaException.class)
    public ResponseEntity<ErroDetalhes> handleFichaNaoEncontradaException(FichaNaoEncontradaException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("A ficha não pôde ser encontrada.");
        erroDetalhes.setStatus(404l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetalhes);
    }

    @ExceptionHandler(InstituicaoNaoEncontradaException.class)
    public ResponseEntity<ErroDetalhes> handleInstituicaoNaoEncontradaException(InstituicaoNaoEncontradaException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("A instituição não pôde ser encontrada.");
        erroDetalhes.setStatus(404l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("htttp://erros.fichacatalografica.com/404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetalhes);
    }
}
