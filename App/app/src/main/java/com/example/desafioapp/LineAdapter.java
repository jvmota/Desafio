package com.example.desafioapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<Tarefa> tarefas;
    private String host;
    private Intent intent;
    private Context contexto;
    public static final String EXTRA_HOST = "com.example.app.HOST";
    public static final String EXTRA_MENU = "com.example.app.MENU";

    public LineAdapter(ArrayList listatarefas, String localhost, Context cont){
        contexto = cont;
        tarefas = listatarefas;
        host = localhost;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tarefa_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position){
        holder.titulo.setText(String.format(Locale.getDefault(), "%d: %s",
                tarefas.get(position).getTarefaID(),
                tarefas.get(position).getNome()
        ));

        if(tarefas.get(position).getConcluido()){
            holder.adicionaFoto.setVisibility(View.GONE);
        }
        else{
            holder.adicionaFoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(contexto, FotoActivity.class);
                    String hostFoto = host + "uploadFotos/" + tarefas.get(position).getTarefaID();
                    intent.putExtra(EXTRA_HOST, hostFoto);
                    intent.putExtra(EXTRA_MENU, host);
                    contexto.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return tarefas != null ?tarefas.size() : 0;
    }
}
