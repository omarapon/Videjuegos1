package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examen.entities.Paisajes;
import com.example.examen.services.PaisajeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActualizarActivity extends AppCompatActivity {
    private Paisajes user = new Paisajes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        //EditText etNombreEditar = findViewById(R.id.etNombreEditar);
        //EditText etEmailEditar = findViewById(R.id.etEmailEditar);
        //EditText etUsernameEditar = findViewById(R.id.etUsernameEditar);

        Button btnAtrasActualizar = findViewById(R.id.btnAtrasActualizar);

        Intent intent = getIntent();
        int temp = intent.getIntExtra("identificador", 0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6477447c9233e82dd53b4dd6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PaisajeService servicio = retrofit.create(PaisajeService.class);
        Call<Paisajes> llamado = servicio.EncontrarContacto(temp);

        btnAtrasActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user.nombre = etNombreEditar.getText().toString();
                //user.email = etEmailEditar.getText().toString();
                //user.username = etUsernameEditar.getText().toString();

                Call<Paisajes> actualizar = servicio.EditarContactos(temp, user);
                actualizar.enqueue(new Callback<Paisajes>() {
                    @Override
                    public void onResponse(Call<Paisajes> call, Response<Paisajes> response) {
                        Intent intent = new Intent(v.getContext(), RetrofitActivity.class);
                        v.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Paisajes> call, Throwable t) {
                    }
                });
            }
        });
    }
}