package com.example.projetozoonoses.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projetozoonoses.R;
import com.example.projetozoonoses.model.Agendamento;
import com.example.projetozoonoses.model.Animal;
import com.example.projetozoonoses.model.Usuario;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterAgendamento extends RecyclerView.Adapter<AdapterAgendamento.AgendamentoViewHolder> {

    private Context context;
    private List<Agendamento> agendamentoList;

    public AdapterAgendamento(Context context, List<Agendamento> agendamentoList) {
        this.context = context;
        this.agendamentoList = agendamentoList;
    }

    @NonNull
    @Override
    public AgendamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        itemLista = layoutInflater.inflate(R.layout.agendamento_cadastro, parent, false);
        return new AgendamentoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendamentoViewHolder holder, int position) {

//        holder.Data.setText(agendamentoList.get(position).getData());
//        holder.Hora.setText(agendamentoList.get(position).getHora());
        holder.Nome.setText(agendamentoList.get(position).getNome());
        holder.Telefone.setText(agendamentoList.get(position).getTelefone());
    }

    @Override
    public int getItemCount() {
        return agendamentoList.size();
    }

    public class AgendamentoViewHolder extends RecyclerView.ViewHolder{


        private TextView Hora;
        private TextView Data;
        private TextView Nome;
        private TextView Telefone;

        public AgendamentoViewHolder(@NonNull View itemView) {
            super(itemView);

            Data = itemView.findViewById(R.id.dt_DataAgendamento);
            Hora = itemView.findViewById(R.id.dt_HoraAgendamento);
            Nome = itemView.findViewById(R.id.nomeUsuarioAgendamento);
            Telefone = itemView.findViewById(R.id.telefoneAgendamento);

        }
    }
}
