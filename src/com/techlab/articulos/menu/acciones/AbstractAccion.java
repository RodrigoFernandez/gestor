package com.techlab.articulos.menu.acciones;

import com.techlab.articulos.interfaces.Accion;
import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.utils.ConsolaUtils;

public abstract class AbstractAccion implements Accion {

    protected Menu menu;

    public AbstractAccion(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    protected int leerEntero(String mensaje) {
        return ConsolaUtils.leerEntero(mensaje, this.getMenu().getScanner());
    }

    protected String leerTexto(String mensaje){
        return ConsolaUtils.leerTexto(mensaje, this.getMenu().getScanner());
    }
    
    protected Double leerDouble(String mensaje) {
        return ConsolaUtils.leerDouble(mensaje, this.getMenu().getScanner());
    }
    
    protected void esperarEnterParaContinuar() {
        ConsolaUtils.esperarEnterParaContinuar(this.getMenu().getScanner());
    }

}
