package com.example.examen_numero3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_numero3.Clases.Contacto;
import com.example.examen_numero3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {
    private List<Contacto> items;

    public ContactAdapter(List<Contacto> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contacto_v, parent, false);
        ContactoUsuarioview viewHolder = new ContactoUsuarioview(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contacto contacto = items.get(position);
        View view = holder.itemView;
        TextView nombre = view.findViewById(R.id.txtUsuario);
        TextView email = view.findViewById(R.id.txtEmail);
        TextView username = view.findViewById(R.id.txtUsername);
        ImageView foto = view.findViewById(R.id.imgPrincipal);
        Button btnEditar = view.findViewById(R.id.btnEditar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);


        //mando los datos a las variable
        nombre.setText(contacto.Nombre);
        email.setText(contacto.email);
        username.setText(contacto.Username);
        Picasso.get().load(contacto.Foto).into(foto);


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ContactoUsuarioview extends RecyclerView.ViewHolder {

        public ContactoUsuarioview(@NonNull View itemView) {
            super(itemView);
        }
    }
}
