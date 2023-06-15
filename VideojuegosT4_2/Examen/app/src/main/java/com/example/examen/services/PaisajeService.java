package com.example.examen.services;

import com.example.examen.entities.Paisajes;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PaisajeService {
    @GET("usuarios")
    Call<List<Paisajes>> ObtenerContactos();

    @PUT("usuarios/{id}")
    Call<Paisajes> EditarContactos(@Path("id") int id, @Body Paisajes user);

    @DELETE("usuarios/{id}")
    Call<Void> EliminarContactos(@Path("id")int id);

    @POST("usuarios")
    Call<Void> CrearContactos(@Body Paisajes user);

    @GET("usuarios/{id}")
    Call<Paisajes> EncontrarContacto(@Path("id") int id);

    @POST("image")
    Call<ImagenResponse> SubirImagen(@Body ImageToSave image);

    class ImagenResponse {
        @SerializedName("url")
        private String url;
        public String getUrl() {
            return url;
        }
    }

    class ImageToSave{
        String base64Image;
        public ImageToSave(String base64Image) {
            this.base64Image = base64Image;
        }
    }
}
