package com.example.five.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    //Padronizado mensagem de exceção do Service
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException){
        return ResponseEntity
                .badRequest()
                .body(Map.of("mensagem", erro.getMessage(),
                        "sucesso", false);
    }

    //Padronizando mensagem de exceção de validação do requestDTO

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException){
        return ResponseEntity
                .badRequest()
                .body(Map.of("Mensagem", erro.getFieldError().get(0).getDefaultMessage(),
                        "sucesso", false));
    }

}
