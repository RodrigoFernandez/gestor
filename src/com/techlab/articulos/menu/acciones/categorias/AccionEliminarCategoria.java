package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.acciones.AbstractAccion;
import com.techlab.articulos.utils.ConsolaUtils;

public class AccionEliminarCategoria extends AbstractAccion {

    private static final String ELIMINACION_EXITOSA = "EXITO";
    private static final String ELIMINACION_FALLIDA = "FALLA";
    private static final String ELIMINACION_FALLIDA_EN_USO = "EN USO";

    public AccionEliminarCategoria(Menu menu) {
        super(menu);
    }

    protected Boolean categoriaTieneArticulosAsociados(int codigo){
        return this.getMenu()
                        .getRepositorioArticulos()
                        .listar()
                        .stream()
                        .filter((a) -> a.getCategoria().getCodigo().equals(codigo))
                        .findFirst()
                        .isPresent();
    }
    protected String eliminarCategoria(int codigo) {
        Boolean hayArticulosQueUsanLaCategoria = this.categoriaTieneArticulosAsociados(codigo);
        
        if(hayArticulosQueUsanLaCategoria){
            return ELIMINACION_FALLIDA_EN_USO;
        }

        return this.getMenu().getRepositorioCategorias().eliminar(codigo) ?
                ELIMINACION_EXITOSA
                : ELIMINACION_FALLIDA;
    }

    @Override
    public void ejecutar() {
        ConsolaUtils.limpiarConsola();

        System.out.println(ConsolaUtils.formatearTitulo("Eliminar categoría por código"));
        int codigo = this.leerEntero("Ingrese código de categoría: ");
        
        String resultado = this.eliminarCategoria(codigo);
        
        switch (resultado) {
            case ELIMINACION_EXITOSA:
                System.out.println("\nCategoría eliminada con éxito. Con código: " + codigo);
                break;
            case ELIMINACION_FALLIDA_EN_USO:
                System.out.println("\nCategoría en uso. No se puede eliminar. Con código: " + codigo);
                break;
            case ELIMINACION_FALLIDA:
                System.out.println("\nNo se encontró una categoría con el código proporcionado (" + codigo + ").");
                break;
        }
        
        this.esperarEnterParaContinuar();
    }

}
