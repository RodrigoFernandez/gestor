package com.techlab.articulos.enums;

public enum TipoArticulo {
    ALIMENTICIO("Alimenticio"), ELECTRONICO("Electronico");

    private String descripcion;

    private TipoArticulo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
