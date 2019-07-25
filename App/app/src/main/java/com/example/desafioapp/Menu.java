package com.example.desafioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    public String host;
    public ArrayList<Tarefa> tarefas;
    RecyclerView ListaTarefasView;
    private LineAdapter adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //define o host para pegar tarefas no servidor back end
        host = message + "tarefas";

        //pega uma lista de objetos
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
        while(tarefas == null){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        setupRecycler();
    }

    private void setupRecycler(){
        ListaTarefasView = findViewById(R.id.recycler_view_tarefas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ListaTarefasView.setLayoutManager(layoutManager);
        adapterLista = new LineAdapter(tarefas);
        ListaTarefasView.setAdapter(adapterLista);
        ListaTarefasView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );
    }

}
