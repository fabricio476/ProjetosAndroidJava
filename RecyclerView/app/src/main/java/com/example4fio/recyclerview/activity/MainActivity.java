package com.example4fio.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example4fio.recyclerview.R;
import com.example4fio.recyclerview.adapter.Adapter;
import com.example4fio.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private List<Filme> listaFilmes = new ArrayList<Filme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); //instanciar o recicler view
        this.criarFilmes();

        //intenciado o adpter que foi criado
        Adapter adpter = new Adapter(listaFilmes);

        //criar e definir o layout do recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

         recyclerView.setLayoutManager(layoutManager); //encluir as definiçoes do leyout na reciclerview

         //melhorar a performace
         recyclerView.setHasFixedSize(true); //metodo informa que vai posuir um tamanho fixo

        //Para criar uma linha divisoria entre os itens
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

         recyclerView.setAdapter(adpter); //adicionado na recycler view o adpter que foi criado

    }

    public void criarFilmes() {

        Filme filme = new Filme("it: A Coisa", "Terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A mumia", "terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A bela e a fera", "romance", "2018");
        this.listaFilmes.add(filme);
        filme = new Filme("carros 3", "comédia", "2000");
        this.listaFilmes.add(filme);
        filme = new Filme("Homem-Aranha", "aventura", "1999");
        this.listaFilmes.add(filme);
        filme = new Filme("Mulher maravilha", "fantasia", "2002");
        this.listaFilmes.add(filme);
        filme = new Filme("pantera negra", "ação", "2015");
        this.listaFilmes.add(filme);
        filme = new Filme("quarteto fantastico", "acão", "2014");
        this.listaFilmes.add(filme);
        filme = new Filme("poderoso chefão", "drama", "2005");
        this.listaFilmes.add(filme);
    }

}