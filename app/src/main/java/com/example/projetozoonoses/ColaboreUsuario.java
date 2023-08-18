package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColaboreUsuario extends AppCompatActivity {
    private Button btnWhatsappColabore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colabore_usuario);
        getSupportActionBar().hide();

        iniciarComponentes();

        btnWhatsappColabore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/5517991880065")));
            }
        });

    }

    private void iniciarComponentes(){
        btnWhatsappColabore= findViewById(R.id.btnWhatsappColabore);
    }
}