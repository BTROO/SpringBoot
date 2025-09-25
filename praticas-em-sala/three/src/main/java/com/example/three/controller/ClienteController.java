package com.example.three.controller;

import com.example.three.model.Cliente;
import com.example.three.repository.ClienteRepository;
import com.example.three.service.ClienteService;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente>ListarTodos(){
        return clienteService.ListarTodos();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }

    @PutMapping ("/{id}")
    public  ResponseEntity<Cliente> atualizar(
            @PathVariable UUID id,
            @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id,cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> excluir (@PathVariable UUID id){
        clienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

