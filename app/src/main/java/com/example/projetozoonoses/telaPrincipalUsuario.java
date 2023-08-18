package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class telaPrincipalUsuario extends AppCompatActivity {

    private ImageView adote;
    private ImageView agende;
    private ImageView sobrenos;
    private ImageView ajude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_usuario);
        getSupportActionBar().hide();
        iniciarComponentes();


        adote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaPrincipalUsuario.this, AdoteUsuario.class);
                startActivity(intent);
            }
        });

        agende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaPrincipalUsuario.this, CastracaoUsuario.class);
                startActivity(intent);
            }
        });

        sobrenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaPrincipalUsuario.this, SobreNosUsuario.class);
                startActivity(intent);
            }
        });

        ajude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telaPrincipalUsuario.this, ColaboreUsuario.class);
                startActivity(intent);
            }
        });
    }



    private void iniciarComponentes(){
        adote = findViewById(R.id.adote);
        agende = findViewById(R.id.agende);
        sobrenos = findViewById(R.id.sobre_nos);
        ajude = findViewById(R.id.ajude);

    }


}