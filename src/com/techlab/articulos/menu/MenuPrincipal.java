package com.techlab.articulos.menu;

import java.util.Scanner;

import com.techlab.articulos.menu.acciones.AccionSalir;
import com.techlab.articulos.utils.ConsolaUtils;

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

        do {
            ConsolaUtils.limpiarConsola();
            this.listarOpcionesMenu("Menu Principal");

            int opcionId = this.leerOpcion();

            this.ejecutarOpcion(opcionId);
        } while (this.continuarSolicitandoOpcion);
        
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        this.obtenerOpcionPorId(opcion).getAccion().ejecutar();
    }

    
}
