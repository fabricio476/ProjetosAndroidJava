package com.galact4app.listadetarefas.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.galact4app.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TerafaDAO implements ITarefaDAO{

    private SQLiteDatabase escreve; // escrever no banco de dados
    private SQLiteDatabase le; // leitura do banco de dados

    public TerafaDAO(Context context) {

        DbHelper db = new DbHelper(context); // instancia classe do banco de dados
        escreve = db.getWritableDatabase(); // escrever no banco de dados
        le = db.getReadableDatabase(); // leitura do banco de dados
    }


    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues values = new ContentValues(); // definir valores para inserir no banco de dados
        values.put("nome", tarefa.getNomeTarefa()); // insere o dado na coluna nome do banco de dados


        try{

          escreve.insert(DbHelper.TABELA_TAREFAS, null, values); // insere dados no banco de dados

            Log.i("INFO", "Tarefa salva com sucesso!");
        }catch (Exception e){

            Log.i("INFO", "Erro ao salvar tarefa: " + e.getMessage());
            return false;
        }


        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues values = new ContentValues(); // definir valores para inserir no banco de dados
        values.put("nome", tarefa.getNomeTarefa()); // insere o dado na coluna nome do banco de dados

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, values, "id=?", args); // insere dados no banco de dados

            Log.i("INFO", "Tarefa atualizada com sucesso!");

        }catch (Exception e){


            Log.i("INFO", "Erro ao atualizar tarefa: " + e.getMessage());
            return false;
        }




        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?", args); // insere dados no banco de dados

            Log.i("INFO", "Tarefa deletada com sucesso!");

        }catch (Exception e){

                Log.i("INFO", "Erro ao deletar tarefa: " + e.getMessage());
                return false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";

        Cursor c = le.rawQuery(sql, null); // executa a query no banco de dados e pega os dados

        while (c.moveToNext()){

            Tarefa tarefa = new Tarefa();

            @SuppressLint("Range") Long id = c.getLong(c.getColumnIndex("id"));
            @SuppressLint("Range") String nomeTarefa = c.getString(c.getColumnIndex("nome"));


            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            tarefas.add(tarefa); // adiciona a tarefa na lista de tarefas

        }

        return tarefas;
    }
}
