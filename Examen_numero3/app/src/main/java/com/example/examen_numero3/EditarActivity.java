package com.example.examen_numero3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen_numero3.Clases.Contacto;
import com.example.examen_numero3.service.UsersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditarActivity extends AppCompatActivity {

    private Contacto contacto = new Contacto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etFoto = findViewById(R.id.etFoto);

        Button btnActualizar = findViewById(R.id.btnActualizar);
        Button btnAtras = findViewById(R.id.btnAtras);

        Intent intent = getIntent();
        int temp = intent.getIntExtra("identificador", 0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://64781c33362560649a2d370d.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersService servicio = retrofit.create(UsersService.class);
        Call<Contacto> llamado = servicio.buscarv(temp);
        llamado.enqueue(new Callback<Contacto>() {
            @Override
            public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                if (response.isSuccessful()) {
                    contacto = response.body();
                    etNombre.setText(contacto.Nombre);
                    etEmail.setText(contacto.email);
                    etUsername.setText(contacto.Username);
                    etFoto.setText(contacto.Foto);
                } else {
                    Log.i("MAIN_APP", "No sirve");}
            }

            @Override
            public void onFailure(Call<Contacto> call, Throwable t) {

            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacto.Nombre = etNombre.getText().toString();
                contacto.email = etEmail.getText().toString();
                contacto.Username = etUsername.getText().toString();
                contacto.Foto = etFoto.getText().toString();

                Call<Contacto> actualizar = servicio.editar(contacto);
                actualizar.enqueue(new Callback<Contacto>() {
                    @Override
                    public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Contacto> call, Throwable t) {
                    }
                });
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}