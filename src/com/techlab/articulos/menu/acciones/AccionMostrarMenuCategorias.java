package com.techlab.articulos.menu.acciones;

import com.techlab.articulos.interfaces.Accion;
import com.techlab.articulos.menu.Menu;

public class AccionMostrarMenuCategorias implements Accion {

    private Menu menu;

    public AccionMostrarMenuCategorias(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void ejecutar() {
        this.menu.mostrarMenu();
    }

}
