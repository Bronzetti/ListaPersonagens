package com.example.listapersonagens.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Personagem implements Serializable { //classe personagem criada para persistência dos dados
    //criação das variáveis para cada personagem
    private  String nome;
    private  String altura;
    private  String nascimento;
    private int id = 0;

    public Personagem(String nome, String altura, String nascimento) {
        //setters
        this.nome = nome;
        this.altura = altura;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    //getters

   /* public String getNome() {
        return nome;
    }

    public String getAltura() {
        return altura;
    }

    public String getNascimento() {
        return nascimento;
    }*/

 //mostrando o nome atribuído ao ir para a lista
    @NonNull
    @Override
    public String toString() {
        return nome;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;

    }
}


