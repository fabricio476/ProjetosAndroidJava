package com.galact4app.listadetarefas;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.galact4app.listadetarefas.adapter.TarefaAdapter;
import com.galact4app.listadetarefas.databinding.FragmentFirstBinding;
import com.galact4app.listadetarefas.helper.DbHelper;
import com.galact4app.listadetarefas.helper.RecyclerItemClickListener;
import com.galact4app.listadetarefas.helper.TerafaDAO;
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

        // Configuração do RecyclerView
        binding.recyclerView.findViewById(R.id.recyclerView);

        // instancia classe do banco de dados
       // DbHelper db = new DbHelper(getActivity());

        // Array com dados para o banco de dados
       // ContentValues values = new ContentValues(); // definir valores para inserir no banco de dados

        //values.put("nome", "Tarefa 1"); // insere o dado na coluna nome do banco de dados

        // insere dados no banco de dados
       // db.getWritableDatabase().insert("tarefas", null, values);


        //Adicionar eventos de click
        binding.recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        binding.recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Recuperar tarefa para edição
                                Tarefa tarefaSelecionada = Listatarefas.get(position);

                                //enviar tarefa para a tela adicionar tarefa
                                Intent intent = new Intent(getActivity(), AdicionarTarefaActivity.class);

                                intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //Recuperar tarefa para deletar
                                Tarefa tarefaSelecionad = Listatarefas.get(position);

                                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir a tarefa: " + tarefaSelecionad.getNomeTarefa() + "?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {



                                        TerafaDAO terafaDAO = new TerafaDAO(getActivity());
                                        if (terafaDAO.deletar(tarefaSelecionad)){

                                            carrergarTarefas(); // recarrega a lista de tarefas

                                            Toast.makeText(getActivity(), "Sucesso ao excluir tarefa!", Toast.LENGTH_SHORT).show();

                                        }else{

                                            Toast.makeText(getActivity(), "Erro ao excluir tarefa!", Toast.LENGTH_SHORT).show();
                                        }

                                   }
                                });

                                dialog.setNegativeButton("Não", null);

                                //Exibir dialog
                                dialog.create();
                                dialog.show();


                            }




                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )

        );




    }

    public void carrergarTarefas(){


        TerafaDAO terafaDAO = new TerafaDAO(getActivity());
        Listatarefas = terafaDAO.listar(); // retorna a lista de tarefas do banco de dados



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