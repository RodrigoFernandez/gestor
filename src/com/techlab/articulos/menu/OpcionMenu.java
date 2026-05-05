package com.techlab.articulos.menu;

import com.techlab.articulos.interfaces.Accion;

public class OpcionMenu {
    private Integer id;
    private String leyenda;
    private Accion accion;

    public OpcionMenu(Integer id, String leyenda, Accion accion) {
        this.id = id;
        this.leyenda = leyenda;
        this.accion = accion;
    }

    public Integer getId() {
        return id;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public Accion getAccion() {
        return accion;
    }

    public String getLeyendaMenu(){
        return this.getId() + ". " + this.getLeyenda();
    }
}
