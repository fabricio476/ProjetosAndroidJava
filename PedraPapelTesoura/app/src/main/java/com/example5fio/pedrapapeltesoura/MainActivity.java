package com.example5fio.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sPedra(View view){
       this.opcaoSelecionada("Pedra");

    }
    public void sPapel(View view){
       this.opcaoSelecionada("Papel");
    }
    public void sTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    
    public void opcaoSelecionada(String opcaoSelecionada){


    }


}