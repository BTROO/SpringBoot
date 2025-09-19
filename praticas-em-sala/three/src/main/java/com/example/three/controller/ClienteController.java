package com.example.three.controller;

import com.example.three.model.Cliente;
import com.example.three.repository.ClienteRepository;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @GetMapping
    public List<Cliente>ListarTodos(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }

    @PutMapping
    public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
        Cliente usuarioAtualizado = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> excluir (@PathVariable UUID id){
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

