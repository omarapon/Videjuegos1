package com.example.examen.services;

import com.example.examen.entities.Users;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsersService {
    @GET("usuarios")
    Call<List<Users>> ObtenerContactos();

    @PUT("usuarios/{id}")
    Call<Users> EditarContactos(@Path("id") int id,@Body Users user);

    @DELETE("usuarios/{id}")
    Call<Void> EliminarContactos(@Path("id")int id);

    @POST("usuarios")
    Call<Void> CrearContactos(@Body Users user);

    @GET("usuarios/{id}")
    Call<Users> EncontrarContacto(@Path("id") int id);

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



