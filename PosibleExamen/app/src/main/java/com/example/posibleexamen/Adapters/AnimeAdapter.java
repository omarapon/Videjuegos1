package com.example.posibleexamen.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posibleexamen.R;
import com.example.posibleexamen.animexd.anime;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AnimeAdapter extends RecyclerView.Adapter{
    List<anime> items;

public AnimeAdapter(List<anime>items){
    this.items= items;

}


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.contactosper,parent,false);
    usuariosViewHolder viewHolder= new usuariosViewHolder(view);
    return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    anime contac=items.get(position);
    View view  = holder.itemView;
        TextView nombreid= view.findViewById(R.id.nombreid);
        TextView  idanime=view.findViewById(R.id.idanime);
        ImageView fotoc=view.findViewById(R.id.fotoc);


        nombreid.setText(contac.getNombre());
        idanime.setText(contac.getDescripcion());
        Picasso.get().load(contac.getFoto()).into(fotoc);


    }



    @Override
    public int getItemCount() {
        return  items.size();
    }
    public  class   usuariosViewHolder extends RecyclerView.ViewHolder{


        public usuariosViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
