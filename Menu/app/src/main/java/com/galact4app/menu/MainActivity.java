package com.galact4app.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override // metodo para criar o menu na tela do app (menu_principal.xml)
    public boolean onCreateOptionsMenu(Menu menu) {

        //retorna o menu criado no arquivo menu.xml
      getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override // metodo para tratar o evento de click dos itens no menu (menu_principal.xml)
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


    switch (item.getItemId()){

            case R.id.itemSalvar:
                //codigo para salvar
                Toast.makeText(this, "Item salvar", Toast.LENGTH_SHORT).show();

                break;

            case R.id.itemEditar:
                //codigo para editar
                Toast.makeText(this, "Item Editar", Toast.LENGTH_SHORT).show();

                break;

            case R.id.itemConfiguração:
                //codigo para configurações

                Toast.makeText(this, "Item Configuração", Toast.LENGTH_SHORT).show();
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}