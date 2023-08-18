package com.example.projetozoonoses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.projetozoonoses.Adapter.AdapterAnimal;
import com.example.projetozoonoses.Adapter.AdapterUsuario;
import com.example.projetozoonoses.RecyclerViewItemClickListener.RecyclerViewItemClickListener;
import com.example.projetozoonoses.model.Animal;
import com.example.projetozoonoses.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CadastroAdministrador extends AppCompatActivity {
    private RecyclerView recyclerView_usuarios;
    private AdapterUsuario adapterUsuario;
    private List <Usuario>  usuarioList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_administrador);
        getSupportActionBar().hide();

        recyclerView_usuarios = findViewById(R.id.recyclerUsuarios);
        usuarioList = new ArrayList<>();
        adapterUsuario = new AdapterUsuario(getApplicationContext(),usuarioList);
        recyclerView_usuarios.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_usuarios.setHasFixedSize(true);
        recyclerView_usuarios.setAdapter(adapterUsuario);

//             DEPOIS DE FAZER OS DETALHES
        //Evento de click no Recycler View
        recyclerView_usuarios.addOnItemTouchListener(
                new RecyclerViewItemClickListener(
                        getApplicationContext(),
                        recyclerView_usuarios,
                        new RecyclerViewItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(CadastroAdministrador.this, detalhe_usuario.class);
                                intent.putExtra("Nome", usuarioList.get(position).getNome());
                                intent.putExtra("Email", usuarioList.get(position).getEmail());
                                intent.putExtra("Senha", usuarioList.get(position).getSenha());
                                startActivity(intent);
                                Usuario usuario = usuarioList.get(position);
//                                Toast.makeText(getApplicationContext(),animal.getNome(),Toast.LENGTH_SHORT).show();

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
        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                                Usuario usuario = queryDocumentSnapshot.toObject(Usuario.class);
                                usuarioList.add(usuario);
                                adapterUsuario.notifyDataSetChanged();
                            }
                        }
                    }
                });




    }
}