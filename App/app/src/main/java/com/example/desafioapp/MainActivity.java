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

    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";
    public String host;
    public boolean ConSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metodo chamado quando se clicar no botao enviar
    public void sendMessage(View view){
        Intent intent = new Intent(this, Menu.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        host = editText.getText().toString();
        host = "http://" + host + ":8080/";
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
                            ConSuccess = true;
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
        });
        intent.putExtra(EXTRA_MESSAGE, host);
        if(ConSuccess) {
            startActivity(intent);
        }
    }
}
