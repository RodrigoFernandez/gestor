package com.techlab.articulos.menu.acciones;

import com.techlab.articulos.interfaces.Accion;
import com.techlab.articulos.menu.Menu;

public class AccionVolver implements Accion {

    private Menu menu;

    public AccionVolver(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void ejecutar() {
        this.menu.setContinuarSolicitandoOpcion(Boolean.FALSE);
    }

}
