package com.techlab.articulos.menu.acciones.articulos;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionConsultarArticulo extends AbstractAccion {

    public AccionConsultarArticulo(Menu menu){
        super(menu);
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();
        System.out.println(ConsolaUtils.formatearTitulo("Consultar artículo por código"));
        int codigo = this.leerEntero("Ingrese código de artículo: ");
        var articulo = this.menu.getRepositorioArticulos().buscarPorCodigo(codigo);
        if(articulo != null){
            System.out.println("\nArtículo encontrado:");
            System.out.printf("Código: %d%n", articulo.getCodigo());
            System.out.printf("Nombre: %s%n", articulo.getNombre());
            System.out.printf("Tipo: %s%n", articulo.getTipoArticulo());
            System.out.printf("Categoría: %d - %s%n", articulo.getCategoria().getCodigo(), articulo.getCategoria().getNombre());
            System.out.printf("Precio: %.2f%n", articulo.getPrecio());
            System.out.printf("Precio Final: %.2f%n", articulo.calcularPrecioFinal());
            System.out.printf("%s%n", articulo.getDetalleEspecifico());
        } else {
            System.out.println("\nNo se encontró un artículo con el código proporcionado.");
        }

        this.esperarEnterParaContinuar();
    }

}
