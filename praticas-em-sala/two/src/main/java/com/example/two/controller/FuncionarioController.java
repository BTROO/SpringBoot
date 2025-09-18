package com.example.two.controller;

import com.example.two.model.Funcionario;
import com.example.two.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    @GetMapping
    public List<Funcionario>ListarTodos (){
        return funcionarioRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Funcionario> salvar (@RequestBody Funcionario funcionario){
        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);

    }
}
