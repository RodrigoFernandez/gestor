package com.techlab.articulos.menu;

import java.util.Scanner;

import com.techlab.articulos.menu.acciones.AccionSalir;

public class MenuPrincipal extends Menu {

    private int idOpcionSalir = 0;

    public MenuPrincipal(Scanner scanner) {
        super(scanner);
        this.opciones.add(new OpcionMenu(idOpcionSalir, "Salir", new AccionSalir(this)));
    }

    public void agregarOpcionMenu(OpcionMenu opcion) {
        this.opciones.add(opcion);
    }

    @Override
    public void mostrarMenu() {
        this.mostrarMenu("Menu Principal");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        this.obtenerOpcionPorId(opcion).getAccion().ejecutar();
    }

    
}
