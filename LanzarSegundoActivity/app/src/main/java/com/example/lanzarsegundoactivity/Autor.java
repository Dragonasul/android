package com.example.lanzarsegundoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Autor extends AppCompatActivity {

    Button btVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        btVolver = (Button)findViewById(R.id.btVolver);
        // Al pulsar el boton
        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: describe la actividad que se debe iniciar y contiene los datos necesarios
                // getContext(): Devuelve el contexto en el que se ejecuta la vista del Activity
                // A través de este contexto se puede acceder al tema actual, recursos, etc
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                // startActivityForResult: Cuando finaliza recibe un resultado de la actividad
                // La actividad recibe el resultado como un objeto Intent
                startActivityForResult(intent,0);
            }
        });
    }
}
