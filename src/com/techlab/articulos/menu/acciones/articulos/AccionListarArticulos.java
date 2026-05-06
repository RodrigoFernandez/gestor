package com.techlab.articulos.menu.acciones.articulos;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionListarArticulos extends AbstractAccion {

    public AccionListarArticulos(Menu menu) {
        super(menu);
    }
    
    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();
        System.out.println(ConsolaUtils.formatearTitulo("Listado de artículos"));
        if(this.menu.getRepositorioArticulos().estaVacio()){
            System.out.println("No hay artículos para mostrar.");
        } else {
            System.out.printf("%-10s %-20s %-10s %-10s %-10s%n", "Código:", "Nombre", "Precio:", "Categoría:", "Tipo:");
            this.menu.getRepositorioArticulos().listar().forEach(articulo -> {
                System.out.printf("%-10d %-20s %-10.2f %-10d %-10s%n", articulo.getCodigo(), articulo.getNombre(), articulo.getPrecio(), articulo.getCategoria().getCodigo(), articulo.getTipoArticulo());
            });
        }

        this.esperarEnterParaContinuar();
    }

}
