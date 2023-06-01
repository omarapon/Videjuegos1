package com.example.examen_numero3.service;
import com.example.examen_numero3.Clases.Contacto;
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
 Call<List<Contacto>> Contactoregistrado();

 @PUT("usuarios/{id}")
    Call<Contacto> editar(@Path("id")Contacto contacto );

 @DELETE("usuarios/{id}")
    Call<Void> eliminar(@Path("id")Contacto contacto);

 @POST("usuarios/{id}")
    Call<Contacto>crear(@Body Contacto contacto);


}
