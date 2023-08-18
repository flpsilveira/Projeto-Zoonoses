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
import com.example.projetozoonoses.model.Usuario;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

    private Context context;
    private List<Usuario> usuarioList;

    public AdapterUsuario(Context context, List<Usuario> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        itemLista = layoutInflater.inflate(R.layout.usuario_cadastro, parent, false);
        return new UsuarioViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.Nome.setText(usuarioList.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{

        private TextView Nome;
        private TextView Email;
        private TextView Senha;


        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            Nome = itemView.findViewById(R.id.nomeUsuario);
            Email = itemView.findViewById(R.id.dt_editEmail);
            Senha = itemView.findViewById(R.id.dt_editSenha);
        }
    }
}
