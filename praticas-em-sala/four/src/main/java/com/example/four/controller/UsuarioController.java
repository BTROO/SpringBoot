package com.example.four.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.four.model.UsuarioModel;
import com.example.four.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

   @PostMapping
public ResponseEntity<Map<String, Object>> salvarUsuario(@RequestBody UsuarioModel usuario) {
  usuarioService.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Map.of("mensagem", "Usuário salvo com sucesso"));
    }
    
    
}
