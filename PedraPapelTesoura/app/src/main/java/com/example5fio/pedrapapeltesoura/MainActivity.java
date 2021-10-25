package com.example5fio.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //metodos do onclik dos componentes da interface
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

        //pegar o coponente da interface
        ImageView imageResultado = findViewById(R.id.id_image_resultado);

        //gerar numeros aleatorios
      int numero = new Random().nextInt(3);

       String[] opcoes = {"pedra","papel","tesoura"}; //criar as opcoes
       String opcaoApp = opcoes[numero]; //escolher umas das opcoes criadas no array

        switch (opcaoApp){

            case "pedra":

                imageResultado.setImageResource(R.drawable.pedra); // metodo para trocar de imagem
                break;

            case "papel":

                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;


        }



    }


}