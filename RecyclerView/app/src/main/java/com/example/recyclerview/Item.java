package com.example.recyclerview;

public class Item {

    private int imagen;
    private String nombrePais;
    private String habitantes;

    // Creamos el Constructor
    public Item(int imagen, String nombrePais, String habitantes) {
        this.imagen = imagen;
        this.nombrePais = nombrePais;
        this.habitantes = habitantes;
    }

    // Generamos los Getters para obtener los datos
    public int getImagen() {
        return imagen;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getHabitantes() {
        return habitantes;
    }


}
