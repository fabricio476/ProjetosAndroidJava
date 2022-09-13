package com.example4fio.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example4fio.recyclerview.R;
import com.example4fio.recyclerview.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

  private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override //CRIAR AS VISULIZAÇÕES
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        //criado uma objeto do tipo View para esibir na lista
        View itemLista = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.view_adpter_lista,viewGroup,false);


        return new MyViewHolder(itemLista); //constroe a view que vai aparecer ma tela
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get(i);
        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());
    }

    @Override// quantidade de items que vão ser exibidos por vez
    public int getItemCount() {

        return listaFilmes.size();
    }

    //uma innerclass - essa classe esta dentro de outra classe (MyViewHolder - é o objeto modelo com as informações)
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(View itemView) {
            super(itemView);

            //conteudo que vai ser mostrado na tela
           titulo = itemView.findViewById(R.id.id_titulo);
           ano = itemView.findViewById(R.id.id_ano);
           genero = itemView.findViewById(R.id.id_genero);


        }
    }


}
