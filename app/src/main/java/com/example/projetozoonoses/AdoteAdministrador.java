package com.example.projetozoonoses;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthRegistrar;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdoteAdministrador extends AppCompatActivity {

    private CircleImageView fotoAnimal;
    private Button bt_selecionarFoto, bt_cadastrarAnimal;
    private EditText edit_nome, edit_cor, edit_observacao, edit_idade, edit_raca,
            edit_vacina, edit_castrado, edit_caracteristicas, edit_sexo;
    private TextView campoVacina;
    List<String> check = new ArrayList<String>();

    private Uri mSelecionarUri;
    String animalID;

    public int f = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adote_administrador);
        getSupportActionBar().hide();
        iniciarComponentes();



        bt_selecionarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarFotoGaleria();
            }
        });

        bt_cadastrarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                   f++;
                SalvarDadosAnimal(view);

                //Após o cadastro ele retorna para a tela principal do admministrador
                Intent intent = new Intent(AdoteAdministrador.this, telaPrincipalAministrador.class);
                startActivity(intent);

        }
        });

//        //provavelmente esse metodo nao vai ficar aqui
//        salvarDadosAnimal();
    }

    public void iniciarComponentes(){
        fotoAnimal = findViewById(R.id.fotoAnimal);
        bt_selecionarFoto = findViewById(R.id.bt_selecioneFoto);
        edit_nome = findViewById(R.id.edit_nome);
        edit_cor = findViewById(R.id.edit_cor);
        edit_observacao = findViewById(R.id.txt_observacao);
        edit_caracteristicas = findViewById(R.id.edit_caracteristicas);
        edit_castrado = findViewById(R.id.edit_castrado);
        edit_idade = findViewById(R.id.edit_idade);
        edit_raca = findViewById(R.id.edit_raca);
        edit_vacina = findViewById(R.id.edit_vacina);
        edit_sexo = findViewById(R.id.edit_sexo);
        bt_cadastrarAnimal = findViewById(R.id.bt_cadastrar);
    }




    ActivityResultLauncher<Intent>activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        //data de dados
                        Intent data = result.getData();
                        mSelecionarUri = data.getData();

                        try{
                            fotoAnimal.setImageURI(mSelecionarUri);

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

    public void selecionarFotoGaleria(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        activityResultLauncher.launch(intent);
    }


//    }
//          TESTE 2
    private void SalvarDadosAnimal(View view){
        String nome, idade, cor, raca, sexo, vacina, castrado, caracteriscas, observacao;
//     sexo, castrado, caractericas, vacinadoSim, vacinadoNao,
        String nomeArquivo = UUID.randomUUID().toString();
        nome = edit_nome.getText().toString();
        idade = edit_idade.getText().toString();
        cor = edit_cor.getText().toString();
        raca = edit_raca.getText().toString();
        sexo = edit_sexo.getText().toString();
        vacina = edit_vacina.getText().toString();
        castrado = edit_castrado.getText().toString();
        caracteriscas = edit_caracteristicas.getText().toString();
        observacao = edit_observacao.getText().toString();


        final StorageReference reference = FirebaseStorage.getInstance().getReference("/imagens/" + nomeArquivo);
        reference.putFile(mSelecionarUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.i("url_img", uri.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> animal = new HashMap<>();
        animal.put("Nome", nome);
        animal.put("Idade", idade);
        animal.put("Cor", cor);
        animal.put("Raça", raca);
        animal.put("Sexo", sexo);
        animal.put("Vacina", vacina);
        animal.put("Castrado", castrado);
        animal.put("Características", caracteriscas);
        animal.put("Observação", observacao);
        animal.put("Foto", nomeArquivo);



        DocumentReference documentReference = db.collection("animais").document(""+f);
        documentReference.set(animal).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db","Sucesso ao salvar os dados");
            }
        })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_erro", "Erro ao salvar os dados" + e);
                    }
                });

        reference.putFile(mSelecionarUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.i("url_img", uri.toString());
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }




}