package com.myexample.teste.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //metodo inicial da aplicação
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metodo para executar(atualizar) uma ação na tela
    public void AlterarTexto(View view){

        //pegar a referencia da caixa de texto da tela pelo Id
        TextView texto = findViewById(R.id.textoExibicao);

        //(altera)adiciona a informação na variavel "texto" que esta refernciana no Id textoexibição
        texto.setText("Hello word");

    }
}