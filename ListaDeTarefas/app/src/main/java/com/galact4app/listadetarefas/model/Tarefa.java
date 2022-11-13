package com.galact4app.listadetarefas.model;

import java.io.Serializable;

// Classe modelo para a tarefa - Serializable para poder passar o objeto entre as activities
public class Tarefa implements Serializable {


    private Long id;
    private String nomeTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
