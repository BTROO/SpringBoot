package com.example.five.controller;

import com.example.five.dto.UsuarioRequestDTO;
import com.example.five.dto.UsuarioResponseDTO;
import com.example.five.model.UsuarioModel;
import com.example.five.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .created(null)
                .body(Map.of(
                        "mensagem", "Cadastrado com sucesso",
                        "sucesso", true));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity
                .ok()
                .body(usuarioService.listarTodos());
    }

    //Update
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {

        usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity
                .ok()
                .body(Map.of("mensagem ", "Atualizar com sucesso", "sucesso", true));
    }

    //Delete
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity
                .ok()
                .body(Map.of("mensagem ", "Atualizar com sucesso", "sucesso", true));
    }

}

