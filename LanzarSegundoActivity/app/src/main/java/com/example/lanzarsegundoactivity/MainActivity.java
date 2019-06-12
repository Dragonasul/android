package com.example.lanzarsegundoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVer = (Button)findViewById(R.id.btVer);

        // Al pulsar el boton
        btVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: describe la actividad que se debe iniciar y contiene los datos necesarios
                // getContext(): Devuelve el contexto en el que se ejecuta la vista del Activity
                // A través de este contexto se puede acceder al tema actual, recursos, etc
                Intent intent = new Intent(v.getContext(), Autor.class);
                // startActivityForResult: Cuando finaliza recibe un resultado de la actividad
                // La actividad recibe el resultado como un objeto Intent
                startActivityForResult(intent,0);
            }
        });
    }
}
