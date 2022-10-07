package com.example4fio.recyclerview.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example4fio.recyclerview.R;
import com.example4fio.recyclerview.RecyclerItemClickListener;
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

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                            }

                            @Override //metodo para quando clicar no item curto
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            @Override //metodo para quando clicar no item longo
                            public void onLongItemClick(View view, int position) {

                                //classe para pegar o item que foi clicado na lista e exibir uma mensagem
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + listaFilmes.get(position).getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }
                        }
                )
        );



    }

    public void criarFilmes() {

        Filme filme = new Filme("it: A Coisa", "Terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A Mumia", "Terror", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("A bela e a Féra", "Romance", "2018");
        this.listaFilmes.add(filme);
        filme = new Filme("Carros 3", "Comédia", "2000");
        this.listaFilmes.add(filme);
        filme = new Filme("Homem-Aranha", "Aventura", "1999");
        this.listaFilmes.add(filme);
        filme = new Filme("Mulher Maravilha", "fantasia", "2002");
        this.listaFilmes.add(filme);
        filme = new Filme("Pantera Negra", "Ação", "2015");
        this.listaFilmes.add(filme);
        filme = new Filme("Quarteto Fantastico", "Acão", "2014");
        this.listaFilmes.add(filme);
        filme = new Filme("Poderoso Chefão", "Drama", "2005");
        this.listaFilmes.add(filme);
    }

}