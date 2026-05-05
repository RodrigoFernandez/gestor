package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionEliminarCategoria extends AbstractAccion {

    public AccionEliminarCategoria(Menu menu) {
        super(menu);
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Eliminar categoría por código"));
        int codigo = this.leerEntero("Ingrese código de categoría: ");
        
        Boolean seEliminoCategoria = this.menu.getRepositorioCategorias().eliminar(codigo);
        
        System.out.println(seEliminoCategoria ?
                            "\nCategoría eliminada con éxito. Con código: " + codigo
                            : "\nNo se encontró una categoría con el código proporcionado (" + codigo + ").");
        
        this.esperarEnterParaContinuar();
    }

}
