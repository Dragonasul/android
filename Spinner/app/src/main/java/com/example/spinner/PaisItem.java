package com.example.spinner;

public class PaisItem {

    private String mNombrePais;
    private int mImagenBandera;

    // Creamos el Constructor que utilizaremos para inicializar nuestros objetos
    public PaisItem(String mNombrePais, int mImagenBandera) {
        this.mNombrePais = mNombrePais;
        this.mImagenBandera = mImagenBandera;
    }

    // Generamos los Getter para obtener los datos
    public String getmNombrePais() {
        return mNombrePais;
    }

    public int getmImagenBandera() {
        return mImagenBandera;
    }


}
