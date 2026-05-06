package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;
import com.techlab.articulos.utils.Secuencias;
import com.techlab.articulos.utils.Validaciones;

public class AccionIngresarCategoria extends AbstractAccion {

    public AccionIngresarCategoria(Menu menu) {
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

        System.out.println(ConsolaUtils.formatearTitulo("Nueva categoría"));
        //System.out.println("Ingresar nombre categoría");
        String nombre = this.leerNombre("Nombre: ");
        String descripcion = this.leerTexto("Descripción: ");
        
        Categoria nuevaCategoria = new Categoria(Secuencias.generarCodigoCategoria(), nombre, descripcion);
        this.menu.getRepositorioCategorias().agregar(nuevaCategoria);
        System.out.println("\nCategoría ingresada con éxito. Con código: " + nuevaCategoria.getCodigo());
        this.esperarEnterParaContinuar();
    }

}
