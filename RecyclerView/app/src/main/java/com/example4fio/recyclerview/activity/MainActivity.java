package com.example4fio.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example4fio.recyclerview.R;

public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); //instanciar o recicler view

        //criar e definir o layout do recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

         recyclerView.setLayoutManager(layoutManager); //encluir as definiçoes do leyout na reciclerview

         //melhorar a performace
         recyclerView.setHasFixedSize(true); //metodo informa que vai posuir um tamanho fixo





    }


}