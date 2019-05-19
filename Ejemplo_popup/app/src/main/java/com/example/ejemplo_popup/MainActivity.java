package com.example.ejemplo_popup;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Creamos dialog a mostrar
    Dialog miDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miDialogo = new Dialog(this);
    }
    //Creamos funcion para cerrar o mostrar el pop up
    public void mostrar_popup(View v){
        TextView tvCerrar;
        Button btSeguir;
        miDialogo.setContentView(R.layout.nuestro_popup);
        tvCerrar = (TextView) miDialogo.findViewById(R.id.tvCerrar);
        btSeguir = (Button) miDialogo.findViewById(R.id.btSeguir);

        tvCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cerramos pop up
                miDialogo.dismiss();
            }
        });
        //Abrimos pop up
        miDialogo.show();
    }
}
