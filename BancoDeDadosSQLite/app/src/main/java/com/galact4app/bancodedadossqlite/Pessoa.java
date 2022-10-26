package com.galact4app.bancodedadossqlite;

public class Pessoa {

    String nome;
    String email;
    String telefone;
    String endereco;
    String cidade;
    String estado;


    public Pessoa(String nome, String email, String telefone, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
