package com.example.desafioapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<Tarefa> tarefas;

    public LineAdapter(ArrayList listatarefas){
        tarefas = listatarefas;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tarefa_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position){
        holder.titulo.setText(String.format(Locale.getDefault(), "%d: %s",
                tarefas.get(position).getTarefaID(),
                tarefas.get(position).getNome()
        ));

        //colocar a acao de adicionar foto depois
    }

    @Override
    public int getItemCount() {
        return tarefas != null ?tarefas.size() : 0;
    }
}
