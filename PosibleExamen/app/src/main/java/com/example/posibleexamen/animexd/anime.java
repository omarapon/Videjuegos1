package com.example.posibleexamen.animexd;

public class anime {
    String Nombre;
    String Descripcion;
    String Foto;

    Boolean estrella;

    public  anime(){}



    public anime(String nombre, String descripcion, String foto, Boolean estrella) {
        Nombre = nombre;
        Descripcion = descripcion;
        Foto = foto;
        this.estrella = estrella;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public Boolean getEstrella() {
        return estrella;
    }

    public void setEstrella(Boolean estrella) {
        this.estrella = estrella;
    }}


