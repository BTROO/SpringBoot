package com.example.five.controller;

import com.example.five.dto.UsuarioRequestDTO;
import com.example.five.model.UsuarioModel;
import com.example.five.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody UsuarioRequestDTO dto)
        UsuarioModel usuario = usuarioService.salvarUsuario(dto)
}
