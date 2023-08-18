package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class telaPrincipalAministrador extends AppCompatActivity {

    private ImageView adote;
    private ImageView img_agendamentos;
    private ImageView img_alterar_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_aministrador);
        getSupportActionBar().hide();
        iniciarComponentes();

        adote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaPrincipalAministrador.this, AdoteAdministrador.class);
                startActivity(intent);
            }
        });

        img_agendamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaPrincipalAministrador.this, AgendeAdministrador.class);
                startActivity(intent);
            }
        });


        img_alterar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaPrincipalAministrador.this, CadastroAdministrador.class);
                startActivity(intent);
            }
        });

    }



    private void iniciarComponentes(){
        adote = findViewById(R.id.adote);
        img_agendamentos = findViewById(R.id.img_agendamentos);
        img_alterar_usuario = findViewById(R.id.img_alterar_usuario);

    }


}