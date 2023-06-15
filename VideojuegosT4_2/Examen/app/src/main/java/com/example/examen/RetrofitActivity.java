package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examen.Adapters.PaisajeAdapter;
import com.example.examen.entities.Paisajes;
import com.example.examen.services.PaisajeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RecyclerView rvListaContactos = findViewById(R.id.rvListaResgistro);
        rvListaContactos.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6477447c9233e82dd53b4dd6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PaisajeService servicio = retrofit.create(PaisajeService.class);
        Call<List<Paisajes>> llamadoLista = servicio.ObtenerContactos();

        llamadoLista.enqueue(new Callback<List<Paisajes>>() {
            @Override
            public void onResponse(Call<List<Paisajes>> call, Response<List<Paisajes>> response) {
                List<Paisajes> listaContacto = response.body();
                PaisajeAdapter adapter = new PaisajeAdapter(listaContacto);
                rvListaContactos.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Paisajes>> call, Throwable t) {

            }
        });

    }
}