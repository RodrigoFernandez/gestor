package com.techlab.articulos.model;

import com.techlab.articulos.enums.TipoArticulo;

public class ArticuloElectronico extends Articulo {

    private Integer garantiaMeses;

    public ArticuloElectronico(Integer codigo, String nombre, Double precio, Categoria categoria,
            Integer garantia) {
        super(codigo, nombre, precio, categoria);
        this.garantiaMeses = garantia;
    }

    public void setGarantiaMeses(Integer garantia) {
        this.garantiaMeses = garantia;
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public Double calcularPrecioFinal() {
        if (garantiaMeses > 12) {
            return getPrecio() * 1.2; // Aumento del 20% si la garantía es mayor a 12 meses
        }
        return getPrecio();
    }

    @Override
    public String getTipoArticulo() {
        return TipoArticulo.ELECTRONICO.getDescripcion();
    }

    @Override
    public String getDetalleEspecifico() {
        return "Garantía: " + garantiaMeses + " meses";
    }
}
