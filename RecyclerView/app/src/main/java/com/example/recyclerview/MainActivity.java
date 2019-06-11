package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

//Implementamos RecyclerViewAdapter.OnItemListener para controlar cuando se pulsa algun item
public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemListener{


    private TextView tvPoblacion;
    private RecyclerView rvPaises;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    ArrayList<Item> ListItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos la referencia de un elemento TextView con id tvPoblacion y la almacenamos en la variable tvPoblacion
        tvPoblacion = (TextView)findViewById(R.id.tvPoblacion);
        //Buscamos la referencia de un elemento RecyclerView con id rvPaises y la almacenamos en la variable rvPaises
        rvPaises = (RecyclerView)findViewById(R.id.rvPaises);
        //Distribuimos los elementos de manera horizontal
        manager = new LinearLayoutManager(this);
        //Opcion para distribuir los elementos de una fila en mas de una columna (Hay que pasar Contexto y numero de celdas).
        //manager = new GridLayoutManager(this, 2);
        //Aplicamos la distribucion de los elementos de manera horizontal al RecyclerView
        rvPaises.setLayoutManager(manager);
        //Creamos el adaptador que servira como puente entre la vista y los datos
        adapter = new RecyclerViewAdapter(this, GetListItems(), this);
        //Asignamos el adaptador
        rvPaises.setAdapter(adapter);

    }
    // Creamos un ArrayList que añade imagen, nombre del pais y los habitantes
    private ArrayList<Item> GetListItems(){
        ListItems.add(new Item(R.drawable.russia_flag_xs, "Rusia", "146 823 000"));
        ListItems.add(new Item(R.drawable.germany_flag_xs, "Alemania", "82 605 000"));
        ListItems.add(new Item(R.drawable.turkey_flag_xs, "Turquia","79 806 000"));
        ListItems.add(new Item(R.drawable.united_kingdom_flag_xs, "Reino Unido","65 893 000"));
        ListItems.add(new Item(R.drawable.france_flag_xs, "Francia","64 765 000"));
        ListItems.add(new Item(R.drawable.italy_flag_xs, "Italia","60 674 000"));
        ListItems.add(new Item(R.drawable.spain_flag_xs, "España","46 491 000"));
        ListItems.add(new Item(R.drawable.ukraine_flag_xs, "Ucrania","42 594 000"));
        ListItems.add(new Item(R.drawable.poland_flag_xs, "Polonia","38 370 000"));
        ListItems.add(new Item(R.drawable.romania_flag_xs, "Rumania","19 659 000"));
        ListItems.add(new Item(R.drawable.kazakhstan_flag_xs, "Kazajistán","17 926 000"));
        return ListItems;
    }

    //Cuando se pulsa algun item de la lista RecyclerView
    public void onItemClick(int position) {
        //Obtenemos la posicion del item pulsado
        Item itemPulsado = (Item) ListItems.get(position);
        //Buscamos la referencia de un elemento TextView con id tvPoblacion y la almacenamos en la variable tvPoblacion
        tvPoblacion = (TextView)findViewById(R.id.tvPoblacion);
        //Obtenemos el nombre del pais pulsado
        String nombrePais = itemPulsado.getNombrePais();
        //Obtenemos los habitantes del pais pulsado
        String habitantesPais = itemPulsado.getHabitantes();
        //Cuando se pulsa un pais creamos este texto
        tvPoblacion.setText( "En "+ nombrePais+ " existen "+ habitantesPais+" habitantes");
        //Toast.makeText(MainActivity.this, nombrePais + " elegido.", Toast.LENGTH_SHORT).show();

    }
}
