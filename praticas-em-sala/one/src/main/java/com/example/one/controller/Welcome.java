package com.example.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/")
    public String dev(){
        return "Desenvolvedor";
    }

    @GetMapping("/dev")
    public String mensagem (){
        return "Ben-vindo";
    }

}
