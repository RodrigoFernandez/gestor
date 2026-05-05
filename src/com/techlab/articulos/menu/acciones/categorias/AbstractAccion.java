package com.techlab.articulos.menu.acciones.categorias;

import com.techlab.articulos.interfaces.Accion;
import com.techlab.articulos.menu.Menu;

public abstract class AbstractAccion implements Accion {

    protected Menu menu;

    public AbstractAccion(Menu menu) {
        this.menu = menu;
    }

    protected int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!this.menu.getScanner().hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            this.menu.getScanner().nextLine(); // Limpiar la entrada no válida
            System.out.print(mensaje);
        }
        int resultado = this.menu.getScanner().nextInt();
        this.menu.getScanner().nextLine(); // Limpiar el salto de línea
        return resultado;
    }

    protected String leerTexto(String mensaje){
        System.out.print(mensaje);
        String resultado;

        do {
            resultado = this.menu.getScanner().nextLine().trim();
        } while (resultado.isEmpty());

        return resultado;
    }
    
    protected void esperarEnterParaContinuar() {
        System.out.println("\nPresione enter para continuar...");
        this.menu.getScanner().nextLine();
    }

}
