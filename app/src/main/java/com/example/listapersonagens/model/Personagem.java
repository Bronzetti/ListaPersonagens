package com.example.listapersonagens.model;

import androidx.annotation.NonNull;

public class Personagem { //classe personagem criada para persistência dos dados
    private final String nome;
    private final String altura;
    private final String nascimento;

    public Personagem(String nome, String altura, String nascimento) {
        //setters
        this.nome = nome;
        this.altura = altura;
        this.nascimento = nascimento;
    }
    //getters

    public String getNome() {
        return nome;
    }

    public String getAltura() {
        return altura;
    }

    public String getNascimento() {
        return nascimento;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}


