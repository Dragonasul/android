package com.example.pasarparametrossegundoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etWeb;
    private Button btAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeb = (EditText)findViewById(R.id.etWeb);
        btAceptar = (Button)findViewById(R.id.btAceptar);

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: describe la actividad que se debe iniciar y contiene los datos necesarios
                // para enviarte al siguiente Activity
                Intent intent = new Intent(v.getContext(), PaginaWeb.class);
                //Forma para enviar variable de tipo String
                intent.putExtra("direccionWeb", etWeb.getText().toString());
                // startActivityForResult: Cuando finaliza recibe un resultado de la actividad
                // La actividad recibe el resultado como un objeto Intent
                startActivityForResult(intent,0);
            }
        });
    }
}
