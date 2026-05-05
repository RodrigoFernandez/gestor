package com.techlab.articulos.utils;

public final class Secuencias {

    private static Integer codigoArticulo = 0;
    private static Integer codigoCategoria = 0;

    private Secuencias() {
    }

    public static Integer generarCodigoArticulo() {
        return ++codigoArticulo;
    }

    public static Integer generarCodigoCategoria() {
        return ++codigoCategoria;
    }
}
