package com.example.macmini3cuceimobile.ciep;


import java.lang.reflect.Array;

import java.util.ArrayList;



/**
 * Created by Mario on 10/11/2015.
 */

public class Informacion {

    static String[] urls6 = {"",""};

    public static ArrayList<DatosDescarga> obtenerDatosGuia(String urls[])
    {
        ArrayList<DatosDescarga> datosDescargas = new ArrayList<>();

        for (String url: urls) {
            datosDescargas.add(new DatosDescarga(url, url, datosDescargas.size()));
        }
        return datosDescargas;
    }
    public static class DatosDescarga {
        private String url;
        private String nombre;
        int indice;

        public DatosDescarga(String url, String nombre, int indice){

            this.url = url;
            this.nombre = nombre;
            this.indice = indice;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        public void setIndice(int indice){
            this.indice = indice;
        }
        public String getUrl(){
            return url;
        }
        public String getNombre(){
            return nombre;
        }
        public int getIndice(){
            return indice;
        }
        public String limpiarUrl(String url){
            String auxiliar = "";
            return  auxiliar;
        }
    }
}

