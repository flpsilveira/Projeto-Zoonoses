package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detalhe_usuario extends AppCompatActivity {
    private TextView dt_nomeUsuario, dt_emailUsuario, dt_senhaUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_usuario);
        getSupportActionBar().hide();

        iniciarComponentes();

        String Nome = getIntent().getExtras().getString("Nome");

//        String Senha = getIntent().getExtras().getString("Senha");

        dt_nomeUsuario.setText(Nome);
        dt_emailUsuario.setText("felipe1@gmail.com");
        dt_senhaUsuario.setText("123456");

    }


    public void iniciarComponentes(){
        dt_nomeUsuario = findViewById(R.id.dt_editNome);
        dt_emailUsuario = findViewById(R.id.dt_editEmail);
        dt_senhaUsuario = findViewById(R.id.dt_editSenha);
    }
}