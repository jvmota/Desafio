package com.example.desafioapp;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {
    public TextView titulo;
    public ImageButton adicionaFoto;

    public LineHolder(View itemView){
        super(itemView);
        titulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
        adicionaFoto = (ImageButton) itemView.findViewById(R.id.imageButtonAdicionar);
    }
}
