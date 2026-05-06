package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionListarCategorias extends AbstractAccion {

    public AccionListarCategorias(Menu menu) {
        super(menu);
    }
    
    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();
        System.out.println(ConsolaUtils.formatearTitulo("Listado de categorías"));
        if(this.menu.getRepositorioCategorias().estaVacio()){
            System.out.println("No hay categorías para mostrar.");
        } else {
            System.out.printf("%-10s %-20s%n", "Código:", "Nombre");
            this.menu.getRepositorioCategorias().listar().forEach(categoria -> {
                System.out.printf("%-10d %-20s%n", categoria.getCodigo(), categoria.getNombre());
            });
        }

        this.esperarEnterParaContinuar();
    }

}
