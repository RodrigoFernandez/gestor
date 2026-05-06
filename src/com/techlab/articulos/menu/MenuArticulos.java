package com.techlab.articulos.menu;

import java.util.Scanner;

import com.techlab.articulos.menu.acciones.AccionVolver;
import com.techlab.articulos.menu.acciones.articulos.AccionConsultarArticulo;
import com.techlab.articulos.menu.acciones.articulos.AccionEliminarArticulo;
import com.techlab.articulos.menu.acciones.articulos.AccionIngresarArticulo;
import com.techlab.articulos.menu.acciones.articulos.AccionListarArticulos;
import com.techlab.articulos.menu.acciones.articulos.AccionModificarArticulo;

public class MenuArticulos extends Menu {

    public MenuArticulos(Scanner scanner) {
        super(scanner);
        this.opciones.add(new OpcionMenu(0, "Volver al menu principal", new AccionVolver(this)));
        this.opciones.add(new OpcionMenu(1, "Ingresar artículo", new AccionIngresarArticulo(this)));
        this.opciones.add(new OpcionMenu(2, "Listar artículos", new AccionListarArticulos(this)));
        this.opciones.add(new OpcionMenu(3, "Consultar un artículo por código", new AccionConsultarArticulo(this)));
        this.opciones.add(new OpcionMenu(4, "Modificar un artículo", new AccionModificarArticulo()));
        this.opciones.add(new OpcionMenu(5, "Eliminar un artículo", new AccionEliminarArticulo()));
    }

    @Override
    public void mostrarMenu() {
        this.mostrarMenu("Menu Articulos");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        this.obtenerOpcionPorId(opcion).getAccion().ejecutar();
    }

}
