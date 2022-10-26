package com.galact4app.listadetarefas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.galact4app.listadetarefas.adapter.TarefaAdapter;
import com.galact4app.listadetarefas.databinding.FragmentFirstBinding;
import com.galact4app.listadetarefas.helper.RecyclerItemClickListener;
import com.galact4app.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> Listatarefas = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.findViewById(R.id.recyclerView);

        //Adicionar eventos de click
        binding.recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        binding.recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Recuperar tarefa para edição
                               // Tarefa tarefaSelecionada = Listatarefas.get(position);

                                Log.i("clique", "onItemClick: " + position);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //Recuperar tarefa para deletar
                               // Tarefa tarefaSelecionada = Listatarefas.get(position);

                                Log.i("clique", "onLongItemClick: " + position);
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )

        );




    }

    public void carrergarTarefas(){
        //Listar tarefas
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeTarefa("Ir ao mercado");
        this.Listatarefas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeTarefa("Ir a feira");
        this.Listatarefas.add(tarefa2);



        //Configurar adapter
        tarefaAdapter = new TarefaAdapter(Listatarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(tarefaAdapter);


    }

    @Override //toda vez que o fragment for exibido na tela ele executa o metodo onsart
    public void onStart() { // Quando o fragmento for iniciado ele vai carregar as tarefas novamente com os dados armazenados
        super.onStart();

        carrergarTarefas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}