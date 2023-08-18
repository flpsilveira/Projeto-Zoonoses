package com.example.projetozoonoses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detalhe_Animal extends AppCompatActivity {

    private ImageView dt_fotoAnimal;
    private TextView dt_nomeAnimal, dt_IdadeAnimal, dt_CorAnimal, dt_RacaAnimal, dt_SexoAnimal,dt_VacinaAnimal,
            dt_CastradoAnimal, dt_CaracteristicasAnimal,dt_ObservacoesAnimal;
    private Button btnQueroAdotar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_animal);
        getSupportActionBar().hide();

        iniciarComponentes();
//
//

        String Características = getIntent().getExtras().getString("Características");
        String Castrado = getIntent().getExtras().getString("Castrado");
        String Cor = getIntent().getExtras().getString("Cor");
        String Foto = getIntent().getExtras().getString("Foto");
        String Idade = getIntent().getExtras().getString("Idade");
        String Nome = getIntent().getExtras().getString("Nome");
        String Observação = getIntent().getExtras().getString("Observação");
        String Raça = getIntent().getExtras().getString("Raça");
        String Sexo = getIntent().getExtras().getString("Sexo");
        String Vacina = getIntent().getExtras().getString("Vacina");


        dt_CaracteristicasAnimal.setText(Características);
        dt_CastradoAnimal.setText(Castrado);
        dt_CorAnimal.setText(Cor);
        Glide.with(getApplicationContext()).load(Foto).into(dt_fotoAnimal);
        dt_IdadeAnimal.setText(Idade);
        dt_nomeAnimal.setText(Nome);
        dt_ObservacoesAnimal.setText(Observação);
        dt_RacaAnimal.setText(Raça);
        dt_SexoAnimal.setText(Sexo);
        dt_VacinaAnimal.setText(Vacina);

        btnQueroAdotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/5517991880065")));
            }
        });

    }

    public void iniciarComponentes(){
        dt_fotoAnimal = findViewById(R.id.dt_fotoAnimal);
        dt_nomeAnimal = findViewById(R.id.dt_nomeAnimal);
        dt_IdadeAnimal = findViewById(R.id.dt_IdadeAnimal);
        dt_CorAnimal = findViewById(R.id.dt_CorAnimal);
        dt_RacaAnimal = findViewById(R.id.dt_RacaAnimal);
        dt_SexoAnimal = findViewById(R.id.dt_SexoAnimal);
        dt_VacinaAnimal = findViewById(R.id.dt_VacinaAnimal);
        dt_CastradoAnimal = findViewById(R.id.dt_CastradoAnimal);
        dt_CaracteristicasAnimal = findViewById(R.id.dt_CaracteristicasAnimal);
        dt_ObservacoesAnimal = findViewById(R.id.dt_ObservacoesAnimal);
        btnQueroAdotar= findViewById(R.id.btnQueroAdotar);
    }
}