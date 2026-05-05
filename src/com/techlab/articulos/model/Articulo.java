package com.techlab.articulos.model;

import com.techlab.articulos.interfaces.Calculable;
import com.techlab.articulos.interfaces.Identificable;

public abstract class Articulo implements Identificable, Calculable {

    protected Integer codigo;
    protected String nombre;
    protected Double precio;
    protected Categoria categoria;

    public Articulo(Integer codigo, String nombre, Double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public abstract String getTipoArticulo();
    public abstract String getDetalleEspecifico();

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

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
                + "]";
    }
}
