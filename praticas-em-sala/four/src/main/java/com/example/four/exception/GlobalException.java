package com.example.four.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(EmailCadastradoException.class)
    public ResponseEntity<Map<String, Object>> handleEmailCadastradoException(EmailCadastradoException erro) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(Map.of("mensagem", erro.getMessage(), "status", "erro"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException erro) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Map.of("mensagem", erro.getMessage()));
    }

    // Remover se não for necessário, ou deixar com nome diferente:
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException erro) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("mensagem", "Erro inesperado: " + erro.getMessage()));
    }
}
