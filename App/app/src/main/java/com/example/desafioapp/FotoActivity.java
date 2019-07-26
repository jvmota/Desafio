package com.example.desafioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FotoActivity extends AppCompatActivity {

    private ImageView FotoCamera;                                           //imageview da activity (foto)
    private String host;                                                    //URL para enviar a foto ao servidor
    private String host_menu;                                               //URL para chamar o menu
    private Bitmap foto;                                                    //objeto bitmap com a foto tirada
    public int code;                                                        //codigo de resposta do servidor
    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";   //string recebida pela activity anterior

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        //pega as strings do intent que iniciou a activity
        Intent intent = getIntent();
        host = intent.getStringExtra(LineAdapter.EXTRA_HOST);
        host_menu = intent.getStringExtra(LineAdapter.EXTRA_MENU);

        //mapeia os objetos da view
        Button btnCamera = findViewById(R.id.buttonCamera);
        FotoCamera = findViewById(R.id.imageViewCamera);

        //some com o botao de enviar foto
        Button envia = findViewById(R.id.buttonEnviar);
        envia.setVisibility(View.INVISIBLE);

        //abre a camera esperando retorno
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    //apos o retorno da camera
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        //cria um bitmap com a foto recebida e a coloca no imageview da activity
        super.onActivityResult(requestCode, resultCode, Data);
        foto = (Bitmap)Data.getExtras().get("data");
        FotoCamera.setImageBitmap(foto);

        //mostra o botao de enviar a foto
        Button envia = findViewById(R.id.buttonEnviar);
        envia.setVisibility(View.VISIBLE);
    }

    //metodo para enviar foto ao servidor
    public void MandarFoto(View view){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //variaveis uteis
                    String lineEnd = "\r\n";
                    String twoHyphens = "--";
                    String boundary = "*****";

                    //abre conexao com o servidor
                    URL url = new URL(host);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    //define propriedades
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    //tipo de requisicao e cabecalho da requisicao
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Connection", "Keep-Alive");
                    connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                    DataOutputStream outputStream;
                    outputStream = new DataOutputStream(connection.getOutputStream());
                    outputStream.writeBytes(twoHyphens + boundary + lineEnd);

                    outputStream.writeBytes("Content-Disposition: form-data; name=\"foto\";filename=\"" + "imagem" + "\"" + lineEnd);
                    outputStream.writeBytes(lineEnd);

                    //transforma a imagem para vetor de bytes e escreve na requisicao
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    foto.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    outputStream.write(byteArray);

                    //finaliza a requisicao
                    outputStream.writeBytes(lineEnd);
                    outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                    //pega o codigo de resposta e fecha a requisicao
                    code = connection.getResponseCode();
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );

        //falta tratamento de erro
        while(code != 200){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //chama o menu
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(EXTRA_MESSAGE, host_menu);
        startActivity(intent);
    }
}