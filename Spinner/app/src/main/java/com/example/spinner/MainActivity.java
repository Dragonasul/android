package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PaisItem> mListaPais;
    private AdaptadorPais mAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciamos la funcion que devuelve nombre del pais y imagen
        iniciarLista();
        //Buscamos la referencia de un elemento con id spinnerPaises y la almacenamos en la variable spinnerPaises
        Spinner spinnerPaises = findViewById(R.id.spinnerPaises);
        //Creamos el adaptador que servira como puente entre la vista y los datos
        mAdaptador = new AdaptadorPais (this, mListaPais);
        //Asignamos el adaptador
        spinnerPaises.setAdapter(mAdaptador);
        spinnerPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //Al pulsar un Item
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Obtenemos la posicion del item pulsado
                PaisItem paisPulsado = (PaisItem) parent.getItemAtPosition(position);
                //Obtenemos el nombre del pais pulsado
                String nombrePaisPulsado = paisPulsado.getmNombrePais();
                //Mensaje de texto con el pais pulsado
                Toast.makeText(MainActivity.this, nombrePaisPulsado + " elegido.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            //No pulsado ningun item
            }
        });
    }

    // Funcion de ArrayList que guarda nombre del pais y imagen
    private void iniciarLista(){
        mListaPais = new ArrayList<>();
        mListaPais.add(new PaisItem("Rumania", R.drawable.ro));
        mListaPais.add(new PaisItem("España", R.drawable.es));
        mListaPais.add(new PaisItem("Italia", R.drawable.it));
        mListaPais.add(new PaisItem("Suecia", R.drawable.se));
    }
}
