package com.myexample.fabricxx.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

     EditText campNome;
     TextInputEditText campEmail;
     TextView textoresultado;


     ///metodo onCreate que abre e configura a tela
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campNome = findViewById(R.id.id_textNome);
        textoresultado = findViewById(R.id.id_TextResultado);
        campEmail = findViewById(R.id.id_TextEmail);

    }


    public void enviar(View view){
       String nome = campNome.getText().toString(); //recuperar a string do componente EditText
       String email = campEmail.getText().toString();
       textoresultado.setText(nome +" " + email); //pasar a string para o outro componente para mostrar na tela

    }

    public void limpar(View view){

        campNome.setText(""); // alterar o texto para campo vasil
        campEmail.setText("");

    }



}