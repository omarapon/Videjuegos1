package com.example.examen_t3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        double numero1;
        double numero2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView respuesta= findViewById(R.id.respuesta);
        Button resta = findViewById(R.id.button1);
        Button suma  = findViewById(R.id.button2);
        Button multiplicacion = findViewById(R.id.buttonPlus);
        Button division = findViewById(R.id.buttonEquals);



        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numero1=Double.parseDouble(num1.getText().toString());
               numero2=Double.parseDouble(num2.getText().toString());
               respuesta.setText(String.valueOf(numero1-numero2));
            }
        });
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1=Double.parseDouble(num1.getText().toString());
                numero2=Double.parseDouble(num2.getText().toString());
                respuesta.setText(String.valueOf(numero1+numero2));
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1=Double.parseDouble(num1.getText().toString());
                numero2=Double.parseDouble(num2.getText().toString());
                respuesta.setText(String.valueOf(numero1*numero2));
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1=Double.parseDouble(num1.getText().toString());
                numero2=Double.parseDouble(num2.getText().toString());
                respuesta.setText(String.valueOf(numero1/numero2));
            }
        });


    }
}
