package com.example.Projeto.controller;

import com.example.Projeto.model.Cliente;
import com.example.Projeto.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> ListarTodos(){
        return clienteRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

}
