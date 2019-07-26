package com.example.desafioapp;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {
    public TextView titulo;
    public ImageButton adicionaFoto;
    public ImageView iconeConcluido;

    public LineHolder(View itemView){
        super(itemView);
        titulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
        adicionaFoto = (ImageButton) itemView.findViewById(R.id.imageButtonAdicionar);
        iconeConcluido = (ImageView) itemView.findViewById(R.id.imageViewConcluido);
    }
}
