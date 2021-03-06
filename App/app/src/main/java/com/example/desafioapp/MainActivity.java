package com.example.desafioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";   //String que sera passada a proxima view
    public String host;                                                     //String que armazenara o ip do host
    public Intent intent;                                                   //Intent para abrir a proxima view

    //metodo padrao de criacao da activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metodo chamado quando se clicar no botao enviar: Pega a string do edittext, cria a intent,
    //cria a comunicacao com o host e se positivo, abre a nova activity (Menu)
    public void sendMessage(View view){
        intent = new Intent(this, Menu.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        host = editText.getText().toString();
        host = "http://" + host + ":8080/";
        intent.putExtra(EXTRA_MESSAGE, host);
        AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                URL EndPointServer = null;
                try {
                    String hostEnter = host + "AppEnter/";
                    EndPointServer = new URL(hostEnter);
                    try {
                        HttpURLConnection myConnection = (HttpURLConnection) EndPointServer.openConnection();
                        if(myConnection.getResponseCode() == 200){
                            startActivity(intent);
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
