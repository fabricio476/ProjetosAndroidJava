package com.example5fio.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void gerarNovaFrase(View view){

        //array
        String[] frases = { "Um líder é alguém que sabe o que quer alcançar e consegue comunicá-lo.",
                            "A maior habilidade de um líder é desenvolver habilidades extraordinárias em pessoas comuns.",
                            "Liderar é a arte de motivar alguém a fazer algo que você quer feito, porque essa pessoa que fazê-lo.",
                             "Contrate caráter, treine habilidades."};

        int numero = new Random().nextInt(4); // vai gerar 4 numeros de 0,1,2,3

         //chamar o elemeto da tela que esta no resorse
         TextView text = findViewById(R.id.text_id_frase);

         text.setText(frases[numero]);

     }



}