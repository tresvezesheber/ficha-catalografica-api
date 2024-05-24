package com.fichacatalograficaapi.fichacatalograficaapi.handler;

import com.fichacatalograficaapi.fichacatalograficaapi.model.ErroDetalhes;
import com.fichacatalograficaapi.fichacatalograficaapi.service.exceptions.FichaNaoEncontradaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {

    private MessageSource messageSource;


    @ExceptionHandler(FichaNaoEncontradaException.class)
    public ResponseEntity<ErroDetalhes> handleFichaNaoEncontradaException(FichaNaoEncontradaException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("A ficha não pôde ser encontrada.");
        erroDetalhes.setStatus(404l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetalhes);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroDetalhes> handleRequisicaoInvalidaException(DataIntegrityViolationException e, HttpServletRequest request) {
        ErroDetalhes erroDetalhes = new ErroDetalhes();
        erroDetalhes.setTitulo("Requsição inválida.");
        erroDetalhes.setStatus(400l);
        erroDetalhes.setTimeStamp(System.currentTimeMillis());
        erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDetalhes);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDetalhes>> handleValidacaoDeAtributoException(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<ErroDetalhes> erroDetalhesList = new ArrayList<ErroDetalhes>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
            ErroDetalhes erroDetalhes = new ErroDetalhes();
            erroDetalhes.setTitulo(error.getDefaultMessage());
            erroDetalhes.setStatus(400l);
            erroDetalhes.setTimeStamp(System.currentTimeMillis());
            erroDetalhes.setMensagemDesenvolvedor("http://erros.fichacatalografica.com/400");
            erroDetalhesList.add(erroDetalhes);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDetalhesList);
    }
}
