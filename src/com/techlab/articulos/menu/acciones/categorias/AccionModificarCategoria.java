package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionModificarCategoria extends AbstractAccion {

    public AccionModificarCategoria(Menu menu) {
        super(menu);
    }

    @Override
    protected String leerTexto(String mensaje){
        System.out.print(mensaje);
        String resultado;
        resultado = this.menu.getScanner().nextLine();
        return resultado;
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Modificar categoría por código"));
        int codigo = this.leerEntero("Ingrese código de categoría: ");
        
        Categoria categoria = this.menu.getRepositorioCategorias().buscarPorCodigo(codigo);
        
        if (categoria != null) {
            System.out.println("\nCategoría encontrada:");            
            System.out.printf("Código: %d%n", categoria.getCodigo());
            String nombre = this.leerTexto("Nombre (" + categoria.getNombre() + "): ");
            String descripcion = this.leerTexto("Descripción (" + categoria.getDescripcion() + "): ");
            
            this.menu.getRepositorioCategorias().eliminar(categoria.getCodigo());
            
            if(!nombre.isEmpty()) {
                categoria.setNombre(nombre);
            }
            
            if(!descripcion.isEmpty()) {
                categoria.setDescripcion(descripcion);
            }
            
            this.menu.getRepositorioCategorias().agregar(categoria);

            System.out.println("\nCategoría modificada con éxito.");
        } else {
            System.out.println("\nNo se encontró una categoría con el código proporcionado.");
        }

        this.esperarEnterParaContinuar();
    }

}
