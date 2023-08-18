package com.example.projetozoonoses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.projetozoonoses.Adapter.AdapterAgendamento;
import com.example.projetozoonoses.RecyclerViewItemClickListener.RecyclerViewItemClickListener;
import com.example.projetozoonoses.model.Agendamento;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AgendeAdministrador extends AppCompatActivity {
    private RecyclerView recyclerView_agendamentos;
    private AdapterAgendamento adapterAgendamento;
    private List<Agendamento> agendamentoList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agende_administrador);
        getSupportActionBar().hide();

        recyclerView_agendamentos = findViewById(R.id.recyclerAgendamento);
        agendamentoList = new ArrayList<>();
        adapterAgendamento = new AdapterAgendamento(getApplicationContext(),agendamentoList);
        recyclerView_agendamentos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_agendamentos.setHasFixedSize(true);
        recyclerView_agendamentos.setAdapter(adapterAgendamento);

        recyclerView_agendamentos.addOnItemTouchListener(
                new RecyclerViewItemClickListener(
                        getApplicationContext(),
                        recyclerView_agendamentos,
                        new RecyclerViewItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(AgendeAdministrador.this, Teste_agendamento.class);
//                                getIntent().putExtra("Nome", agendamentoList.get(position).getNome());
//                                getIntent().putExtra("Telefone",agendamentoList.get(position).getTelefone());
//                                getIntent().putExtra("Data", agendamentoList.get(position).getData());
//                                getIntent().putExtra("Hora",agendamentoList.get(position).getHora());

                                startActivity(intent);
//                                Agendamento agendamento = agendamentoList.get(position);
//                                Agendamento agendamento = agendamentoList.get(position);
//                                Toast.makeText(getApplicationContext(),agendamento.getHora(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

        db = FirebaseFirestore.getInstance();
        db.collection("agendamentos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                                Agendamento agendamentoo = queryDocumentSnapshot.toObject(Agendamento.class);
                                agendamentoList.add(agendamentoo);
                                adapterAgendamento.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}