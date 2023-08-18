package com.example.projetozoonoses;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

public class CastracaoUsuario extends AppCompatActivity {

    private Button bt_agendar;
    private EditText edit_dataAgenda, edit_horaAgenda, edit_telefoneAgenda, edit_nomeAgenda;
    public int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castracao_usuario);
        getSupportActionBar().hide();

        iniciarComponentes();

        bt_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x++;
                SalvarDadosAgendamento(view);

                Intent intent = new Intent(CastracaoUsuario.this, telaPrincipalUsuario.class);
                startActivity(intent);
            }
        });
    }

    public void iniciarComponentes(){
        edit_dataAgenda = findViewById(R.id.edit_dataAgenda);
        edit_horaAgenda = findViewById(R.id.edit_horaAgenda);
        edit_telefoneAgenda = findViewById(R.id.edit_telefoneAgenda);
        edit_nomeAgenda = findViewById(R.id.edit_nomeAgenda);
        bt_agendar = findViewById(R.id.bt_agendar);



    }



    public void SalvarDadosAgendamento(View view){
        String data, hora, telefone, nome;
        data = edit_dataAgenda.getText().toString();
        hora = edit_horaAgenda.getText().toString();
        telefone = edit_telefoneAgenda.getText().toString();
        nome = edit_nomeAgenda.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> agenda = new HashMap<>();
        agenda.put("Data",data);
        agenda.put("Hora",hora);
        agenda.put("Telefone", telefone);
        agenda.put("Nome", nome);

        DocumentReference documentReference = db.collection("agendamentos").document(""+x);
        documentReference.set(agenda).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db","Sucesso ao salvar os dados");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db_erro", "Erro ao salvar os dados" + e);
            }
        });

    }
}