package com.galact4app.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            // Criar banco de dados (caso não exista) e abrir conexão com o mesmo (caso exista)
            SQLiteDatabase bancoDados = openOrCreateDatabase("NomeBanco", MODE_PRIVATE, null); // MODE_PRIVATE: somente a aplicação pode acessar o banco de dados

            // Criar tabela (caso não exista) e inserir dados na mesma (caso exista)
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))"); // INT(3): inteiro de 3 dígitos

            //------------------------ INSERIR DADOS ------------------------
            // Inserir dados na tabela
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mariana', 18)"); // INSERT INTO: inserir dados na tabela
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 50)"); // Não é necessário fechar a conexão com o banco de dados, pois o método openOrCreateDatabase() já faz isso automaticamente
           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('João', 30)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 25)");
           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('José', 40)");

            //----------------------------- UPDATE ---------------------------------------------------------------------------------

            // Atualizar dados na tabela UPDATE
            // bancoDados.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Mariana'"); // UPDATE: atualizar dados na tabela
            // bancoDados.execSQL("UPDATE pessoas SET idade = 51 WHERE id = 2"); // WHERE: condição para atualizar os dados

            //--------------------------------------------------------------------------------------------------------------
            // bancoDados.execSQL("DROP TABLE pessoas"); // DROP TABLE: deletar tabela do banco de dados INTEIRA


            //-------------------------------------DELETE-------------------------------------------------------------------------
            // Deletar dados na tabela DELETE
             bancoDados.execSQL("DELETE FROM pessoas WHERE id = 1"); // DELETE FROM: deletar dados na tabela WHERE: condição para deletar os dados (id = 1)
            // bancoDados.execSQL("DELETE FROM pessoas ); // deleta todos os dados da tabela





            // Recuperar dados da tabela
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Mariana' AND idade = 18"; // WHERE: condição para a consulta
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Mariana'";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 18"; // >=: maior ou igual a
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 18 AND 50"; // BETWEEN: entre
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Mariana' OR idade = 50"; // OR: ou
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome IN ('Mariana', 'Pedro')"; // IN: dentro de
            //String consulta = "SELECT id, nome, idade FROM pessoas WHERE 1 = 1"; // 1 = 1: sempre verdadeiro (consulta todos os dados da tabela)
            String consulta = "SELECT * FROM pessoas WHERE 1 = 1"; // *: todos os campos da tabela
           // String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'M%'"; // LIKE: consulta com base em um padrão (M%: nome que começa com a letra M)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%a'"; // LIKE: consulta com base em um padrão (%a: nome que termina com a letra a)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%a%'"; // LIKE: consulta com base em um padrão (%a%: nome que contém a letra a)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%a%' AND idade = 18"; // LIKE: consulta com base em um padrão (%a%: nome que contém a letra a)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY nome ASC"; // ORDER BY: ordenar os dados da consulta (ASC: crescente)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY nome DESC"; // ORDER BY: ordenar os dados da consulta (DESC: decrescente)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY idade ASC"; // ORDER BY: ordenar os dados da consulta (ASC: crescente)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY idade DESC"; // ORDER BY: ordenar os dados da consulta (DESC: decrescente)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY idade ASC LIMIT 1"; // LIMIT: limitar a quantidade de dados da consulta (1: apenas 1 dado)
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1 = 1 ORDER BY idade ASC LIMIT 3"; // LIMIT: limitar a quantidade de dados da consulta (3: apenas 3 dados)


             //String consulta = "SELECT nome, idade FROM pessoas";
             Cursor cursor = bancoDados.rawQuery(consulta, null); // SELECT: selecionar dados da tabela

            // Recuperar índices das colunas
            int indiceColunaId = cursor.getColumnIndex("id"); // Recuperar índice da coluna id
            int indiceColunaNome = cursor.getColumnIndex("nome"); // getColumnIndex(): retorna o índice da coluna
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); // moveToFirst(): move o cursor para o primeiro registro da tabela (para iniciar a leitura dos dados do começo))

            while (cursor != null) { // cursor != null: enquanto houver dados na tabela (percorrermos todos os registros da tabela)

                // Recuperar dados
                int id = cursor.getInt(indiceColunaId); // getInt(): retorna o valor inteiro do índice da coluna
                String nome = cursor.getString(indiceColunaNome); // getString(): retorna o valor da coluna
                String idade = cursor.getString(indiceColunaIdade);

                Log.i("RESULTADO - ID: ", id + " / nome: "+ nome + " idade: " + idade); // Exibe os dados no Logcat

               // Log.i("Resultado - nome: ", cursor.getString(indiceColunaNome)); // getString(): retorna o valor da coluna
               // Log.i("Resultado - idade: ", cursor.getString(indiceColunaIdade));

                cursor.moveToNext(); // moveToNext(): move o cursor para o próximo registro da tabela (para continuar a leitura dos dados)

            }



        }catch (Exception e){

            e.printStackTrace(); // Imprime o erro no console.
        }



    }
}