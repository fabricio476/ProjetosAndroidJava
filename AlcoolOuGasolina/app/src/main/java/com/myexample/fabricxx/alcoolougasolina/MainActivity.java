package com.myexample.fabricxx.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.id_campAlcool);
        editPrecoGasolina = findViewById(R.id.id_campGasolina);
        textResultado = findViewById(R.id.id_campResultado);

    }

    public void calcularPreco(View view){

        //recuperar valores digitados
         String precoAlcool = editPrecoAlcool.getText().toString();
         String precoGasolina = editPrecoGasolina.getText().toString();

         //validar se os dois campos estão prenchidos
         Boolean resultado = validarCampos(precoAlcool,precoGasolina); // se verdadeiro

         if(resultado){

             Double valorAlcool = Double.parseDouble(precoAlcool); //recebe o valor da variavel convertido para dolble
             Double valorGasolina = Double.parseDouble( precoGasolina);

             Double result = valorAlcool / valorGasolina;

             if(result >= 0.7 ){
                 textResultado.setText("Melhor utilizar Gasolina");
             }else{
                 textResultado.setText("Melhor utilizar Alcool");
             }

         }else {
             textResultado.setText("Preencha os preços primeiro");
         }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina ){

        Boolean camposValidados = true;

        if( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals(" ")){
            camposValidados = false;
        }

        return camposValidados;

    }




}