package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen.entities.Users;
import com.example.examen.services.UsersService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditarActivity extends AppCompatActivity {
    private Users user = new Users();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        TextView etNombre = findViewById(R.id.etNombre);
        ImageView etFoto = findViewById(R.id.imFotoPokemon);

        Button btnAtras= findViewById(R.id.btnAtras);

        Intent intent = getIntent();
        int temp = intent.getIntExtra("identificador", 0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6477447c9233e82dd53b4dd6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersService servicio = retrofit.create(UsersService.class);
        Call<Users> llamado = servicio.EncontrarContacto(temp);
        llamado.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                user = response.body();
                etNombre.setText(user.nombre);
                Picasso.get().load(user.foto).into(etFoto);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PrincipalActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        /*btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.nombre = etNombre.getText().toString();
                user.email = etEmail.getText().toString();
                user.username = etUsername.getText().toString();
                user.foto = etFoto.getText().toString();

                Call<Users> actualizar = servicio.EditarContactos(temp, user);
                actualizar.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Intent intent = new Intent(v.getContext(), RetrofitActivity.class);
                        v.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                    }
                });
            }
        });*/
    }
}