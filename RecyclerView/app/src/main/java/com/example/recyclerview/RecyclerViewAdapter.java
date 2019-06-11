package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Un RecyclerView es un contenedor de elementos en forma de lista que permite "reciclar" los ítems
// que ya no son visibles por el usuario debido al scrolling.
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Item> listItems;
    private OnItemListener mOnItemListener;

    // Creamos el Constructor
    public RecyclerViewAdapter(Context context, ArrayList<Item> listItems, OnItemListener onItemListener) {
        this.context = context;
        this.listItems = listItems;
        this.mOnItemListener = onItemListener;
    }

    // La forma que tenemos de inflar nuestro layout es a través onCreateViewHolder.
    // Por cada tipo de vista a visualizar, tendrá su propio layout.
    // En la estructura definimos una clase padre de todos los ViewHolder y es esta la que le devolvemos.
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // LayoutInflater, es el nombre de la variable que generalmente es usada para inflar un layout en Android
        View contentView = LayoutInflater.from(context).inflate(R.layout.layout_item_lista, null);
        return new Holder(contentView, mOnItemListener);
    }

    // onBindViewHolder: Cargar datos del modelo a la vista.
    // Aquí recibimos el ViewHolder creado en el anterior método. Lo único que hacemos es
    // pasarle el modelo al ViewHolder para que se encargue el de establecer sus propios datos.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        //Obtenemos la posicion del item pulsado
        Item item = listItems.get(position);
        Holder Holder = (Holder) viewHolder;
        Holder.ivImagenPais.setImageResource(item.getImagen());
        Holder.tvNombrePais.setText(item.getNombrePais());
    }
    //Devolvemos el tamaño de la lista Items
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    //Después de que un adaptador cree o reutilice una vista, busca el lugar dentro del layout
    //donde tiene que mostrar la información con el método findViewById().
    //Con el objeto View Holder conseguimos que esa referencia se establezca cuando se crea
    //la vista y se guarde para no tener que volver a buscar.
    //Básicamente lo que se consigue con este patrón es evitar utilizar el método findViewById()
    //cada vez que se tenga que mostrar un nuevo elemento de la lista.
    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivImagenPais;
        TextView tvNombrePais;
        OnItemListener onItemListener;
        public Holder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            ivImagenPais = itemView.findViewById(R.id.ivImagenPais);
            tvNombrePais = itemView.findViewById(R.id.tvNombrePais);
            //Controlamos si se ha pulsado algun item
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Obtener la posicion del item pulsado
            onItemListener.onItemClick(getAdapterPosition());
        }
    }


    //La interfaz es una clase abstracta donde se indican los métodos, pero no se implementa ninguno.
    //Permite establecer una estructura que ha de seguir toda clase que implemente esta interfaz.
    public interface OnItemListener{
        void onItemClick(int position);
    }
}
