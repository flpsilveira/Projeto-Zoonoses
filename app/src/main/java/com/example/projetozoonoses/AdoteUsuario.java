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

import com.example.projetozoonoses.Adapter.AdapterAnimal;
//import com.example.projetozoonoses.RecyclerViewItemClickListener.RecyclerViewItemClickListener;
import com.example.projetozoonoses.RecyclerViewItemClickListener.RecyclerViewItemClickListener;
import com.example.projetozoonoses.model.Animal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class AdoteUsuario extends AppCompatActivity {
    private RecyclerView recyclerView_animais;
    private AdapterAnimal adapterAnimal;
    private List<Animal> animalList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adote_usuario);
        getSupportActionBar().hide();

        recyclerView_animais = findViewById(R.id.recyclerAnimais);
        animalList = new ArrayList<>();
        adapterAnimal = new AdapterAnimal(getApplicationContext(),animalList);
        recyclerView_animais.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_animais.setHasFixedSize(true);
        recyclerView_animais.setAdapter(adapterAnimal);


        //Evento de click no Recycler View
        recyclerView_animais.addOnItemTouchListener(
                new RecyclerViewItemClickListener(
                        getApplicationContext(),
                        recyclerView_animais,
                        new RecyclerViewItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(AdoteUsuario.this, Detalhe_Animal.class);
                                intent.putExtra("Características", animalList.get(position).getCaracterísticas());
                                intent.putExtra("Castrado", animalList.get(position).getCastrado());
                                intent.putExtra("Cor", animalList.get(position).getCor());
                                intent.putExtra("Foto",animalList.get(position).getFoto());
                                intent.putExtra("Idade", animalList.get(position).getIdade());
                                intent.putExtra("Nome", animalList.get(position).getNome());
                                intent.putExtra("Observação", animalList.get(position).getObservação());
                                intent.putExtra("Raça",animalList.get(position).getRaça());
                                intent.putExtra("Sexo", animalList.get(position).getSexo());
                                intent.putExtra("Vacina", animalList.get(position).getVacina());
                                startActivity(intent);
                                Animal animal = animalList.get(position);
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
        db.collection("animais")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                                Animal animalll = queryDocumentSnapshot.toObject(Animal.class);
                                animalList.add(animalll);
                                adapterAnimal.notifyDataSetChanged();
                            }
                        }
                    }
                });




    }
}