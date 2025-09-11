package com.example.Projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senai")

public class Welcome {
    @GetMapping("/")
    public String mensagen(){
        return "Ben-vindo";
    }

    @GetMapping("/dev")
    public String dev(){
        return "Kailane";
    }

    @GetMapping("/reuniao")
    public String reunião(){
        return "Bem-vindo a reunião";
    }
}
