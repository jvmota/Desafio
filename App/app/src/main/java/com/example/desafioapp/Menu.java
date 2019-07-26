package com.example.desafioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    public String host;                     //host com o URL base das tarefas
    public String message;                  //host com o URL para enviar foto
    public ArrayList<Tarefa> tarefas;       //lista com as tarefas que serao carregadas
    RecyclerView ListaTarefasView;          //recycler view que vai mostrar a lista de tarefas
    private LineAdapter adapterLista;       //Adapter que ira transformar os objetos da lista para o recycler view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Pega o Intent que iniciou a activity e pega a string passada
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //define o host para pegar tarefas no servidor back end
        host = message + "tarefas";

        //pega uma lista do servidor e o mapeia na ArrayList com o Jackson
        final ObjectMapper mapper = new ObjectMapper();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tarefas = mapper.readValue(new URL(host), new TypeReference<ArrayList<Tarefa>>(){});                                 // read from url
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //para a thread ate que a lista seja retornada (carece de tratamento de erro)
        while(tarefas == null){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //mapeia a lista no recycler view
        setupRecycler();
    }

    //metodo para mapear o recycler view
    private void setupRecycler(){
        ListaTarefasView = findViewById(R.id.recycler_view_tarefas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ListaTarefasView.setLayoutManager(layoutManager);
        adapterLista = new LineAdapter(tarefas, message, this);
        ListaTarefasView.setAdapter(adapterLista);
        ListaTarefasView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );
    }

}
