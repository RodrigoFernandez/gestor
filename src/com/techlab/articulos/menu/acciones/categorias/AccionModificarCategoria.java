package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;
import com.techlab.articulos.utils.Validaciones;

public class AccionModificarCategoria extends AbstractAccion {

    public AccionModificarCategoria(Menu menu) {
        super(menu);
    }

    @Override
    protected String leerTexto(String mensaje) {
        boolean continuoPidiendoIngreso = true;
        String texto = "";

        do {
            System.out.print(mensaje);
            texto = this.getMenu().getScanner().nextLine().trim();

            if(!Validaciones.validarTextoNoVacio(texto)){
                System.out.println("El texto no puede estar vacío. Por favor, ingrese un valor válido.");
            } else {
                continuoPidiendoIngreso = false;
            }
        } while (continuoPidiendoIngreso);

        return texto;
    }

    protected String leerNombre(String mensaje) {
        boolean continuoPidiendoIngreso = true;
        String texto = "";

        do {
            System.out.print(mensaje);
            texto = this.getMenu().getScanner().nextLine().trim();

            if(!Validaciones.validarTextoNoVacio(texto)){
                System.out.println("El texto no puede estar vacío. Por favor, ingrese un valor válido.");
            } else {
                if(this.getMenu().getRepositorioCategorias().buscarPorNombre(texto) != null){
                    System.out.println("Ya existe una categoría con ese nombre. Por favor, ingrese un nombre diferente.");
                } else {
                    continuoPidiendoIngreso = false;
                }
            }
        } while (continuoPidiendoIngreso);

        return texto;
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
            String nombre = this.leerNombre("Nombre (" + categoria.getNombre() + "): ");
            String descripcion = this.leerTexto("Descripción (" + categoria.getDescripcion() + "): ");
            
            //Revisar esto
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
