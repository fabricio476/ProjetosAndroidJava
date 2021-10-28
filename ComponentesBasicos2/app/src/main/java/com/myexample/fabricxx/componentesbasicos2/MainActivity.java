package com.myexample.fabricxx.componentesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.id_CompNome);
        campoEmail = findViewById(R.id.id_CampEmail);
        textoResultado = findViewById(R.id.Id_TextResultado);

        checkVerde = findViewById(R.id.id_checkVerde);
        checkBranco = findViewById(R.id.id_checkBranco);
        checkVermelho = findViewById(R.id.id_checkVermelho);


    }

    public void checkbox(){

        //boolean resultadoVerde = checkVerde.isChecked(); //retorna verdadeiro ou falso
        //textoResultado.setText("verde: " + resultadoVerde );

        String texto ="";

        if( checkVerde.isChecked() ){

            //ESSA FORMA NÃO NECESITA DE ESTAR DENTRO DO IF , FUNCIONA SEMPRE QUE CLICAR NO CHECKBOX
            String corSelecionada = checkVerde.getText().toString(); // desta forma o metodo gettext pega o texto do chebox que aparece na tela
            texto = corSelecionada;


         //   texto = "verde selecionado - ";
        }

        if( checkBranco.isChecked() ){
            texto = texto + "Branco selecionado - ";
        }

        if( checkVermelho.isChecked() ){

            texto = texto + "Vermelho selecionado - ";
        }

      textoResultado.setText(texto);

    }


    public void enviar(View view){

        checkbox();

       // String nome = campoNome.getText().toString();
       // String email = campoEmail.getText().toString();

      //  textoResultado.setText("nome: " + nome + " email:" + email );
    }

   public void limpar(View view){

       campoNome.setText("");
       campoEmail.setText("");
       textoResultado.setText("");

    }





    }