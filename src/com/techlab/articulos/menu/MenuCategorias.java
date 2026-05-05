package com.techlab.articulos.menu;

import java.util.Scanner;

import com.techlab.articulos.menu.acciones.AccionVolver;
import com.techlab.articulos.menu.acciones.categorias.AccionConsultarCategoria;
import com.techlab.articulos.menu.acciones.categorias.AccionEliminarCategoria;
import com.techlab.articulos.menu.acciones.categorias.AccionIngresarCategoria;
import com.techlab.articulos.menu.acciones.categorias.AccionListarCategorias;
import com.techlab.articulos.menu.acciones.categorias.AccionModificarCategoria;
import com.techlab.articulos.utils.ConsolaUtils;

public class MenuCategorias extends Menu {

    public MenuCategorias(Scanner scanner) {
        super(scanner);
        this.opciones.add(new OpcionMenu(0, "Volver al menu principal", new AccionVolver(this)));
        this.opciones.add(new OpcionMenu(1, "Ingresar categoría", new AccionIngresarCategoria(this)));
        this.opciones.add(new OpcionMenu(2, "Listar categorías", new AccionListarCategorias(this)));
        this.opciones.add(new OpcionMenu(3, "Consultar una categoría por código", new AccionConsultarCategoria(this)));
        this.opciones.add(new OpcionMenu(4, "Modificar una categoría", new AccionModificarCategoria(this)));
        this.opciones.add(new OpcionMenu(5, "Eliminar una categoría", new AccionEliminarCategoria(this)));
    }

    @Override
    public void mostrarMenu() {
        do {
            ConsolaUtils.limpiarConsola();
            
            this.listarOpcionesMenu("Menu Categorias");

            int opcionId = this.leerOpcion();

            this.ejecutarOpcion(opcionId);
        } while (this.continuarSolicitandoOpcion);
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        this.obtenerOpcionPorId(opcion).getAccion().ejecutar();
    }
}
