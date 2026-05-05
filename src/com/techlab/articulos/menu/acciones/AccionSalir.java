package com.techlab.articulos.menu.acciones;

import com.techlab.articulos.interfaces.Accion;
import com.techlab.articulos.menu.Menu;

public class AccionSalir implements Accion {

    private Menu menu;

    public AccionSalir(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void ejecutar() {
        System.out.println("Saliendo del programa...");
        this.menu.getScanner().close();
        this.menu.setContinuarSolicitandoOpcion(Boolean.FALSE);
        System.out.println("Hasta la próxima!");
    }

}
