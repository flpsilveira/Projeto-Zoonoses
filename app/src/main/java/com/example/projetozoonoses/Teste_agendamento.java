package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teste_agendamento extends AppCompatActivity {

    private Button btnWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_agendamento);
        getSupportActionBar().hide();

        iniciarComponentes();

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/5517991880065")));
            }
        });

    }

    private void iniciarComponentes(){
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
    }

}