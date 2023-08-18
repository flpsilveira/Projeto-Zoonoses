package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SobreNosUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos_usuario);
        getSupportActionBar().hide();
    }
}