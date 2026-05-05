package com.techlab.articulos.model;

import com.techlab.articulos.interfaces.Identificable;

public class Categoria implements Identificable {

    private Integer codigo;
    private String nombre;
    private String descripcion;

    public Categoria(Integer codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public Integer getCodigo() {
        return this.codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Categoria [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
}
