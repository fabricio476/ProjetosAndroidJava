package com.myexample.teste2.sorteio;

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

    //ação que do botão jogar (referenciado na tela Onclick)
    public void Jogar(View view){

      //  int numero = 5;

        //gerar um numero aleatorio de 0.. a 10, (colocado 11 pois começa de 0)
        int numero = new Random().nextInt(11);

        //faz referencia por id da textview do id selecionado, e trasfere para a variavel "texto"
        TextView texto = findViewById(R.id.textoNumeroSelecionado);

        //a variavel "texto" recebe a String("Numero sorteado: ") + o valor da variavel numero(q é um int)
        texto.setText("Numero sorteado: " + numero);

    }


}