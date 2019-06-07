package com.example.spinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Un objeto Adapter actúa como un puente entre el AdapterView y los datos de una Vista (View).
// El Adapter proporciona acceso a cada item. El adaptador también es responsable de hacer
// una vista para cada producto en la coleccion de datos.
public class AdaptadorPais extends ArrayAdapter<PaisItem> {

     // Creamos el Constructor
     public AdaptadorPais (Context context, ArrayList<PaisItem> paisList){
     super(context, 0, paisList);
     }

    // Generamos Override Methods (Control + O)
    // Elegimos getView y getDropDownView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    // Inicializamos la vista del Spinner
    private View initView(int position, View convertView, ViewGroup parent){
         //En caso de que la vista este vacia (null) mostramos el layout spinner
        if(convertView == null){
            // LayoutInflater, es el nombre de la variable que generalmente es usada para inflar un layout en Android
            // Metafora para entender Layoutinflater:
            // Layoutinflater es comparado con un hinchador de playa, dentro va el XML como gas y
            // la pelota de playa sería la variable tipo vista/View dónde se carga el XML
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.paises_spinner, parent, false);
        }
        //Declaramos la variable imagen y nombre
        ImageView ivImagenPais = convertView.findViewById(R.id.ivImagenPais);
        TextView tvNombrePais = convertView.findViewById(R.id.tvNombrePais);
        //Obtenemos la posicion del item pulsado
        PaisItem itemActual = getItem(position);

        //En caso de que el item NO este vacio (null)
        if(itemActual != null) {
            //Agregamos a cada item la imagen y el texto
            ivImagenPais.setImageResource(itemActual.getmImagenBandera());
            tvNombrePais.setText(itemActual.getmNombrePais());
        }

        return convertView;
        }
}
