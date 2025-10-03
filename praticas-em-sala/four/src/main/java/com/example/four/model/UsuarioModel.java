package com.example.four.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @AllArgsConstructor // fazer o construtor completo sozinho 
 @NoArgsConstructor // construtor vazio 
 @Data // getters e setters e to string
@Entity
@Table(name = "tab_usuario")
public class UsuarioModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;
}

  
