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

    private ImageView FotoCamera;
    private String host;
    private String host_menu;
    private Bitmap foto;
    public int code;
    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Intent intent = getIntent();
        host = intent.getStringExtra(LineAdapter.EXTRA_HOST);
        host_menu = intent.getStringExtra(LineAdapter.EXTRA_MENU);

        Button btnCamera = findViewById(R.id.buttonCamera);
        FotoCamera = findViewById(R.id.imageViewCamera);

        Button envia = findViewById(R.id.buttonEnviar);
        envia.setVisibility(View.INVISIBLE);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        super.onActivityResult(requestCode, resultCode, Data);
        foto = (Bitmap)Data.getExtras().get("data");
        FotoCamera.setImageBitmap(foto);
        Button envia = findViewById(R.id.buttonEnviar);
        envia.setVisibility(View.VISIBLE);
    }

    public void MandarFoto(View view){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String lineEnd = "\r\n";
                    String twoHyphens = "--";
                    String boundary = "*****";
                    URL url = new URL(host);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Connection", "Keep-Alive");
                    connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                    DataOutputStream outputStream;
                    outputStream = new DataOutputStream(connection.getOutputStream());
                    outputStream.writeBytes(twoHyphens + boundary + lineEnd);

                    outputStream.writeBytes("Content-Disposition: form-data; name=\"foto\";filename=\"" + "imagem" + "\"" + lineEnd);
                    outputStream.writeBytes(lineEnd);

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    foto.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    outputStream.write(byteArray);

                    outputStream.writeBytes(lineEnd);
                    outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

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