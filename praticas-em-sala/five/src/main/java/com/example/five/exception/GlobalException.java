package com.example.five.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    // Padronizando mensagem de exceção do Service
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "sucesso", false
                ));
    }

    // Padronizando mensagem de exceção de validação do requestDTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException erro) {
        String mensagemErro = erro.getFieldError() != null
                ? erro.getFieldError().getDefaultMessage()
                : "Erro de validação";

        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", mensagemErro,
                        "sucesso", false
                ));
    }

    // Padronizando RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runTimeException(RuntimeException erro) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "sucesso", false
                ));
    }
}
