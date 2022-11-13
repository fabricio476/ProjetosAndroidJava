package com.galact4app.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

// classe para criar o banco de dados
public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 2; // versão do banco de dados
    public static String NOME_DB = "DB_TAREFAS"; // nome do banco de dados
    public static String TABELA_TAREFAS = "tarefas"; // nome da tabela

    public DbHelper(@Nullable Context context) {



        super(context, NOME_DB, null, VERSION);
    }

    @Override //criar o banco primeira vez
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //criar a tabela de tarefas
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABELA_TAREFAS+" (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);";


        try {

            sqLiteDatabase.execSQL(sql); // executa o comando sql

            Log.i("INFO DB", "Sucesso ao criar a tabela");

        }catch (Exception e){

            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }



    }

    @Override // atualizar o banco
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // deletar a tabela de tarefas
        String sql = "DROP TABLE IF EXISTS "+ TABELA_TAREFAS+";";

        // alterar a tabela de tarefas para adicionar a coluna status
        //String sql = "ALTER TABLE "+ TABELA_TAREFAS+" ADD COLUMN status VARCHAR(2);";


        try {

            sqLiteDatabase.execSQL(sql); // executa o comando sql

           onCreate(sqLiteDatabase); // cria a tabela novamente

            Log.i("INFO DB", "Sucesso ao atualizar a tabela");

        }catch (Exception e){

            Log.i("INFO DB", "Erro ao atualizar a tabela" + e.getMessage());
        }


    }
}
