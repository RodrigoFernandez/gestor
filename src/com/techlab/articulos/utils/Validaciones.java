package com.techlab.articulos.utils;

import java.util.List;

public final class Validaciones {

    private Validaciones() {
    }

    public static Boolean validarTextoNoVacio(String texto){
        return texto != null && !texto.trim().isEmpty();
    }

    public static Boolean validarLongitudMaxima(String texto, int maximo){
        return texto != null && texto.length() <= maximo;
    }

    public static Boolean validarNoNegativo(int valor){
        return valor >= 0;
    }
    
    public static Boolean validarNoNegativo(double valor){
        return valor >= 0;
    }

    public static Boolean esOpcionValida(int opcionIngresada, List<Integer> opcionesValidas) {
        return opcionesValidas.contains(opcionIngresada);
    }
}
