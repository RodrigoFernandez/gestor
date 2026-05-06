package com.techlab.articulos.menu.acciones.articulos;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.model.Articulo;
import com.techlab.articulos.model.ArticuloAlimenticio;
import com.techlab.articulos.model.ArticuloElectronico;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.utils.ConsolaUtils;
import com.techlab.articulos.utils.Secuencias;
import com.techlab.articulos.utils.Validaciones;

public class AccionIngresarArticulo extends AbstractAccion {

    public AccionIngresarArticulo(Menu menu) {
        super(menu);
    }

    private boolean hayCategorias() {
        return !this.getMenu().getRepositorioCategorias().estaVacio();
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

    protected Double leerPrecio(String mensaje) {
        Double precio = Double.valueOf(-1);
        boolean ingresoValido = false;

        do {
            precio = this.leerDouble(mensaje);
            
            if (Validaciones.validarNoNegativo(precio)) {
                ingresoValido = true;
            } else {
                System.out.println("El precio no puede ser negativo. Por favor, ingrese un valor válido.");
            }
            
        } while (!ingresoValido);

        return precio;
    }

    protected Categoria leerCategoria(String mensaje) {
        boolean ingresoValido = false;
        Categoria categoria = null;

        do {
            Integer codigo = this.leerEntero(mensaje);

            categoria = this.getMenu().getRepositorioCategorias().buscarPorCodigo(codigo);
            if(categoria == null){
                System.out.println("Categoría no encontrada. Por favor, ingrese un código de categoría válido.");
            } else {
                ingresoValido = true;
            }
            
        } while (!ingresoValido);

        return categoria;
    }

    protected Integer leerGarantia(String mensaje) {
        Integer garantia = -1;
        boolean ingresoValido = false;

        do {
            garantia = this.leerEntero(mensaje);
            
            if (Validaciones.validarNoNegativo(garantia)) {
                ingresoValido = true;
            } else {
                System.out.println("La garantía no puede ser negativa. Por favor, ingrese un valor válido.");
            }
            
        } while (!ingresoValido);

        return garantia;
    }

     protected Integer leerDiasVencimiento(String mensaje) {
        Integer diasVencimiento = -1;
        boolean ingresoValido = false;

        do {
            diasVencimiento = this.leerEntero(mensaje);
            
            if (Validaciones.validarNoNegativo(diasVencimiento)) {
                ingresoValido = true;
            } else {
                System.out.println("Los días de vencimiento no pueden ser negativos. Por favor, ingrese un valor válido.");
            }
            
        } while (!ingresoValido);

        return diasVencimiento;
    }
    
    private Boolean ingresarArticulo() {
        Articulo articulo;

        Boolean esElectronico = ConsolaUtils.leerSiNo("Es artículo electrónico ", this.menu.getScanner());
        System.out.println("Ingresando artículo " + (esElectronico ? "electrónico" : "alimenticio") + ".");
        
        String nombre = this.leerTexto("Nombre: ");
        Double precio = this.leerPrecio("Precio: ");
        Categoria categoria = this.leerCategoria("Categoría (ingrese código): ");

        
        if(esElectronico){
            Integer garantiaMeses = this.leerGarantia("Garantía (meses): ");
            articulo = new ArticuloElectronico(Secuencias.generarCodigoArticulo(), nombre, precio, categoria, garantiaMeses);
        } else {
            Integer diasVencimiento = this.leerDiasVencimiento("Días de vencimiento: ");
            articulo = new ArticuloAlimenticio(Secuencias.generarCodigoArticulo(), nombre, precio, categoria, diasVencimiento);
        }

        this.getMenu().getRepositorioArticulos().agregar(articulo);

        return Boolean.TRUE;
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Nuevo artículo"));

        if(!this.hayCategorias()){
            System.out.println("No hay categorías disponibles. Por favor, ingrese una categoría antes de agregar un artículo.");
            this.esperarEnterParaContinuar();
        } else {
            Boolean ingresoExitoso = this.ingresarArticulo();

            System.out.println(ingresoExitoso ? "Artículo ingresado exitosamente." : "No se pudo ingresar el artículo. Por favor, intente nuevamente.");
            this.esperarEnterParaContinuar();
        }
    }

}
