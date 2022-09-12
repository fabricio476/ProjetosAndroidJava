package com.example4fio.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais; // uma lista para adicionar o ADAPTER com o conteudo da lista
    private String[] itens = {"curitiba", "são paulo","santa catarina","rio grande do sul","rio de janeiro","minas gerais",
    "parana","para","ceara","sergipe","tocantins","fortaleza","amazonas","roraima","rodonia","alagoas"
    ,"espirito santo","mato grasso do sul","goias","brasilia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.id_lista);

        //um adapter para a listview       -parametros-
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //forma(desing do item da liste ) ctrl + clik para visualizar
                android.R.id.text1, //o id do simple_list_item_1
                itens //o lista de dados que vai ser colocada nos itens
        );

        //adiciona um adaptador para a lista
        listLocais.setAdapter(adaptador); //adapta os dados para a lista

        //metodo para ler o item que foi clicado
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //pega o valor do item clicado
                String valorSelecionado = listLocais.getItemAtPosition(i).toString(); //to string para tranfomar o i em string

                //printar na tela mesagem de Toast
                Toast.makeText(getApplicationContext(), valorSelecionado,Toast.LENGTH_LONG).show();
            }
        });

    }
}