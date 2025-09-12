package com.example.Projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_cliente") //apelido para o banco
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o id automatico
    private Long id;

    @Column(nullable = false)  //campo não pode ficar vazio
    private String nome;

    @Column(nullable = false)
    private String telefone;

    //Construtor vazio

    public Cliente() {
    }


    //CONSTRUTOR

    public Cliente(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
