package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;
import com.techlab.articulos.utils.Secuencias;

public class AccionIngresarCategoria extends AbstractAccion {

    public AccionIngresarCategoria(Menu menu) {
        super(menu);
    }
    
    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Nueva categoría"));
        System.out.println("Ingresar nombre categoría");
        String nombre = this.leerTexto("Nombre: ");
        String descripcion = this.leerTexto("Descripción: ");
        
        Categoria nuevaCategoria = new Categoria(Secuencias.generarCodigoCategoria(), nombre, descripcion);
        this.menu.getRepositorioCategorias().agregar(nuevaCategoria);
        System.out.println("\nCategoría ingresada con éxito. Con código: " + nuevaCategoria.getCodigo());
        this.esperarEnterParaContinuar();
    }

}
