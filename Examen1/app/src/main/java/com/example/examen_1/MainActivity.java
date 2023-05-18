package com.example.examen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Integer> numbers = new ArrayList<>();
    int var;
    Random r = new Random();
    int num4, num5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView personaje1a = findViewById(R.id.personaje1a);
        TextView personaje1b = findViewById(R.id.personaje1b);
        TextView personaje2a = findViewById(R.id.personaje2a);
        TextView personaje2b = findViewById(R.id.personaje2b);
        TextView ganadorj = findViewById(R.id.ganadorj);


        Button idpersonaje = findViewById(R.id.idpersonaje);
        Button resfactor = findViewById(R.id.resfactor);
        idpersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idpersonaje.getText().equals("personaje1")) {
                    num4 = r.nextInt(11);
                    personaje1a.setText("personaje1");
                    idpersonaje.setText("personaje2");
                    personaje1b.setText(num4 + "");

                } else if (idpersonaje.getText().equals("personaje2")) {
                    num5 = r.nextInt(11);
                    personaje2a.setText("personaje2");

                    personaje2b.setText(num5 + "");
                    if (num4 > num5) {
                        ganadorj.setText("Persona1 win");

                    } else if (num4 == num5) {
                        ganadorj.setText("empate");
                    } else {
                        ganadorj.setText("Persona2 win");

                    }
                }
            }
        });
        resfactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personaje1a.setText("");
                idpersonaje.setText("personaje1");
                personaje1b.setText("");
                personaje2a.setText("");
                personaje2b.setText("");
                ganadorj.setText("");

            }
        });
    }
}

