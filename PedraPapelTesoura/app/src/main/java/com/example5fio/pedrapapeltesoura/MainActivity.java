package com.example5fio.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //metodos do onclik dos componentes da interface
    public void sPedra(View view){
       this.opcaoSelecionada("pedra");

    }
    public void sPapel(View view){
       this.opcaoSelecionada("papel");
    }
    public void sTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada(String opcaoSelecionada){

        //pegar o coponente da interface
        ImageView imageResultado = findViewById(R.id.id_image_resultado);
        TextView textoResultado = findViewById(R.id.id_text_result);

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

        ///codigo para criar as regras do jogo
        if( (opcaoApp == "tesoura" && opcaoSelecionada == "papel") || (opcaoApp == "papel" && opcaoSelecionada == "pedra") || (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){ //App ganhador

            textoResultado.setText("Voce Perdeu! :( ");

        }else if( (opcaoApp == "papel" && opcaoSelecionada == "tesoura") || (opcaoApp == "pedra" && opcaoSelecionada == "papel") || (opcaoApp == "tesoura" && opcaoSelecionada == "pedra")
        ){//Usuario ganhador

            textoResultado.setText("Voce Ganhou! : ) ");

        }else{//Empate

            textoResultado.setText("Empatamos! ; ) ");


        }



    }


}