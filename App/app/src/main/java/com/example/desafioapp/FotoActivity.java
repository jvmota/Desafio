package com.example.desafioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView FotoCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Intent intent = getIntent();
        String host = intent.getStringExtra(LineAdapter.EXTRA_HOST);

        Button btnCamera = findViewById(R.id.buttonCamera);
        FotoCamera = findViewById(R.id.imageViewCamera);

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
        Bitmap foto = (Bitmap)Data.getExtras().get("data");
        FotoCamera.setImageBitmap(foto);
    }
}