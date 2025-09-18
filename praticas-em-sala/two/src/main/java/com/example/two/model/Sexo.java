package com.example.two.model;

public enum Sexo {
    FEMININO("Feminino"),
    MASCULINO("Masculino");

    private String texto;

    Sexo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
