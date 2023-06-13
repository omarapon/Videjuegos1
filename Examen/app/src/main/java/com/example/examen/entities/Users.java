package com.example.examen.entities;

import com.example.examen.Clases.Comentarios;

import java.util.List;

public class Users {
    public int ID;
    public String nombre;
    public String email;
    public String username;
    public String foto;

    public String FotosUrl;

    List<Comentarios> comentariosList;
    void Agregarcomentarios(Comentarios comentarios){
        comentariosList.add(comentarios);


    }
}
