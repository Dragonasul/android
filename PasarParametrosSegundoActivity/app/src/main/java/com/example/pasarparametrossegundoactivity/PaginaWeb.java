package com.example.pasarparametrossegundoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class PaginaWeb extends AppCompatActivity {

    private WebView wvVistaWeb;
    private Button btFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        wvVistaWeb = (WebView)findViewById(R.id.wvVistaWeb);

        //Recuperamos el dato enviado del anterior Activity
        Bundle bundle = getIntent().getExtras();
        //Lo guardamos en la variable dato
        String dato = bundle.getString("direccionWeb");
        //Utilizamos setWebViewClient para mostrar la web en la aplicación sin salir de la App.
        wvVistaWeb.setWebViewClient(new WebViewClient());
        //Cargamos la pagina web
        wvVistaWeb.loadUrl("https://"+dato);

        btFinalizar = (Button)findViewById(R.id.btFinalizar);
        //Al pulsar el boton
        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Destruye una actividad y no podrás acceder a ella hasta que la vuelvas a crear
                finish();
                //vuelve a la Actividad o Fragmento anterior al que te encuentras en el momento
                //onBackPressed();
            }
        });

    }
}
