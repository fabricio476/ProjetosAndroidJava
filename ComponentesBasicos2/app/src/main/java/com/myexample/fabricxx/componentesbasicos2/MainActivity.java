package com.myexample.fabricxx.componentesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;

    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.id_CompNome);
        campoEmail = findViewById(R.id.id_CampEmail);
        textoResultado = findViewById(R.id.Id_TextResultado);

        //checkBox
        checkVerde = findViewById(R.id.id_checkVerde);
        checkBranco = findViewById(R.id.id_checkBranco);
        checkVermelho = findViewById(R.id.id_checkVermelho);

        //RadioButton
        sexoMasculino = findViewById(R.id.id_RadioMasculino);
        sexoFeminino = findViewById(R.id.id_RadioFeminino);
        opcaoSexo = findViewById(R.id.id_RadioGroup);

        RadioButton(); // metodo para ficar escutando o botão radio sempre que for alterado

    }

    public void RadioButton(){

        //METODO DO RADIOGROUP PARA ESCUTAR A OPÇÃO SELECIONADA
       opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {

               if(i == R.id.id_RadioMasculino){

                  textoResultado.setText("Masculino");

               }else if(i == R.id.id_RadioFeminino){

                   textoResultado.setText("Feminino");
               }
           }
       });





      //   sexoMasculino.isChecked(); //retorna verdadeira ou falso de o RaioButons estiver selecionado


        /*
        //metodo para executar a opção selecionada
        if(sexoMasculino.isChecked()){
            textoResultado.setText("Masculino!");
        }else if(sexoFeminino.isChecked()){
            textoResultado.setText("Feminino!");
        }

         */


    }





    //metodo do botão SALVAR
    public void enviar(View view){

      //  checkbox(); //chama o metodo com as funcionalidades do checkbox

      //  preencherTexto(); // chama o metodo de preencher os campos nome e email

         RadioButton();

    }

    //metodo para o botão LIMPAR
   public void limpar(View view){
       campoNome.setText("");
       campoEmail.setText("");
       textoResultado.setText("");
    }


    //metodo para preencher os dados de email e nome
    public void preencherTexto(){

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultado.setText("nome: " + nome + " email:" + email );

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





    }