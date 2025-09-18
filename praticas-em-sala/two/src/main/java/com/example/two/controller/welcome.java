package com.example.two.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/f")
    public String funcionario(){
        return "Funcionario";
    }

    @GetMapping("/endereco")
    public String endereco(){
        return "Endereço";

    }
}
