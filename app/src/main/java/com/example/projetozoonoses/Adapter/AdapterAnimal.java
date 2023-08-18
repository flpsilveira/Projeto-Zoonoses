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
import com.example.projetozoonoses.model.Animal;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterAnimal extends RecyclerView.Adapter<AdapterAnimal.AnimalViewHolder> {

    private Context context;
    private List<Animal> animalList;

    public AdapterAnimal(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        itemLista = layoutInflater.inflate(R.layout.animal_cadastro, parent, false);
        return new AnimalViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
//        holder.Foto.setImageResource(animalList.get(position).getFoto());// ver
        Glide.with(context).load(animalList.get(position).getFoto()).into(holder.Foto);
        holder.Nome.setText(animalList.get(position).getNome());
        holder.Sexo.setText(animalList.get(position).getSexo());
//        holder.Idade.setText(animalList.get(position).getIdade());
//        holder.Cor.setText(animalList.get(position).getCor());
//        holder.Raça.setText(animalList.get(position).getRaça());
//        holder.Vacina.setText(animalList.get(position).getVacina());
//        holder.Castrado.setText(animalList.get(position).getCastrado());
//        holder.Características.setText(animalList.get(position).getCaracterísticas());
//        holder.Observação.setText(animalList.get(position).getObservação());

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView Foto;
        private TextView Nome;
        private TextView Sexo;
        private TextView Idade;
        private TextView Cor;
        private TextView Raça;
        private TextView Vacina;
        private TextView Castrado;
        private TextView Características;
        private TextView Observação;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            Foto = itemView.findViewById(R.id.fotoAnimal);
            Nome = itemView.findViewById(R.id.nomeAnimal);
            Sexo = itemView.findViewById(R.id.sexoAnimal);
            Idade = itemView.findViewById(R.id.dt_IdadeAnimal);
            Cor = itemView.findViewById(R.id.dt_CorAnimal);
            Raça = itemView.findViewById(R.id.dt_RacaAnimal);
            Vacina = itemView.findViewById(R.id.dt_VacinaAnimal);
            Castrado = itemView.findViewById(R.id.dt_CastradoAnimal);
            Características = itemView.findViewById(R.id.dt_CaracteristicasAnimal);
            Observação = itemView.findViewById(R.id.dt_ObservacoesAnimal);
        }
    }
}
