package com.galact4app.listadetarefas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.galact4app.listadetarefas.R;
import com.galact4app.listadetarefas.helper.TerafaDAO;
import com.galact4app.listadetarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        // recuperar tarefa caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        // configurar tarefa na caixa de texto
        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override // metodo on click dos items do menu de opções
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.itemSalvar:

            // intancia a classe TarefaDAO para salvar a tarefa
            TerafaDAO tarefaDAO = new TerafaDAO(getApplicationContext());

            String nomeTarefa = editTarefa.getText().toString();


            if (tarefaAtual != null) { // tarefa atualizada

                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa(nomeTarefa);
                tarefa.setId(tarefaAtual.getId());

                // atualizar tarefa
                if (tarefaDAO.atualizar(tarefa)) {
                    finish();
                    Toast.makeText(getApplicationContext(), "Sucesso ao atualizar tarefa!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa!", Toast.LENGTH_SHORT).show();
                }

            } else { // tarefa salva

                if (!nomeTarefa.isEmpty()) {

                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    // salvar tarefa
                    if (tarefaDAO.salvar(tarefa)) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                    }

                }

            }


                break;

        }

        return super.onOptionsItemSelected(item);
    }




}