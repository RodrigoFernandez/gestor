package com.techlab.articulos.model;

import com.techlab.articulos.enums.TipoArticulo;

public class ArticuloAlimenticio  extends Articulo {

    private Integer diasParaVencimiento;
    
    public ArticuloAlimenticio(Integer codigo, String nombre, Double precio, Categoria categoria,
            Integer diasParaVencimiento) {
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    public void setDiasParaVencimiento(Integer diasParaVencimiento) {
        this.diasParaVencimiento = diasParaVencimiento;
    }

    public Integer getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    @Override
    public String getTipoArticulo() {
        return TipoArticulo.ALIMENTICIO.getDescripcion();
    }

    @Override
    public String getDetalleEspecifico() {
        return "Dias para vencimiento: " + diasParaVencimiento;
    }

    @Override
    public Double calcularPrecioFinal() {
        if (diasParaVencimiento <= 5) {
            return getPrecio() * 0.5; // Descuento del 50% si quedan 5 días o menos para el vencimiento
        }
        return getPrecio();
    }
}
