package com.galact4app.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.galact4app.listadetarefas.R;
import com.galact4app.listadetarefas.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private List<Tarefa> tarefas;

    public TarefaAdapter(List<Tarefa> listatarefas) {

           this.tarefas = listatarefas;

    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new TarefaViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {

        Tarefa tarefa = tarefas.get(position);
        holder.textTarefa.setText(tarefa.getNomeTarefa());


    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }



    public class TarefaViewHolder extends RecyclerView.ViewHolder{

        TextView textTarefa;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);

            textTarefa = itemView.findViewById(R.id.id_text_tarefa);
        }
    }

}
