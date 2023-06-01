package com.example.examen_numero3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.example.examen_numero3.Adapter.ContactAdapter;
import com.example.examen_numero3.Clases.Contacto;
import com.example.examen_numero3.service.UsersService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView registrovs = findViewById(R.id.registrovs);
        registrovs.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://6477447c9233e82dd53b4dd6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsersService service=retrofit.create(UsersService.class);
        Call<List<Contacto>>llamadolista=service.Contactoregistrado();
        llamadolista.enqueue(new Callback<List<Contacto>>() {
            @Override
            public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {
                List<Contacto>contactoList=response.body();
                ContactAdapter adapter=new ContactAdapter(contactoList);
                registrovs.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Contacto>> call, Throwable t) {
                Log.i("MAIN_APP", "No sirve");

            }
        });

    }
}