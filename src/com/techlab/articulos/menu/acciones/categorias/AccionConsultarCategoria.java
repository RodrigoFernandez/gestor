package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionConsultarCategoria extends AbstractAccion {

    public AccionConsultarCategoria(Menu menu) {
        super(menu);
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Consultar categoría por código"));
        int codigo = this.leerEntero("Ingrese código de categoría: ");
        Categoria categoria = this.menu.getRepositorioCategorias().buscarPorCodigo(codigo);
        if (categoria != null) {
            System.out.println("\nCategoría encontrada:");
            System.out.printf("Código: %d%n", categoria.getCodigo());
            System.out.printf("Nombre: %s%n", categoria.getNombre());
            System.out.printf("Descripción: %s%n", categoria.getDescripcion());
        } else {
            System.out.println("\nNo se encontró una categoría con el código proporcionado.");
        }

        this.esperarEnterParaContinuar();
    }

}
