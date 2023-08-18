//package com.example.projetozoonoses;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class detalhe_agendamento extends AppCompatActivity {
//
//    TextView dt_nomeUsuario, dt_TelefoneContato,dt_DataAgendamento, dt_HoraAgendamento;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detalhe_agendamento);
//        getSupportActionBar().hide();
//
//        iniciarComponentes();
//
//        String Nome = getIntent().getExtras().getString("Nome");
//        String Telefone = getIntent().getExtras().getString("Telefone");
//        String Data = getIntent().getExtras().getString("Data");
//        String Hora = getIntent().getExtras().getString("Hora");
//
//        dt_nomeUsuario.setText(Nome);
//        dt_TelefoneContato.setText(Telefone);
//        dt_DataAgendamento.setText(Data);
//        dt_HoraAgendamento.setText(Hora);
//
//
//    }
//
//
//    public void iniciarComponentes(){
//        dt_nomeUsuario = findViewById(R.id.dt_nomeUsuario);
//        dt_TelefoneContato = findViewById(R.id.dt_TelefoneContato);
//        dt_DataAgendamento = findViewById(R.id.dt_DataAgendamento);
//        dt_HoraAgendamento = findViewById(R.id.dt_HoraAgendamento);
//    }
//}