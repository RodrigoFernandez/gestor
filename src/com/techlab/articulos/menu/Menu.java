package com.techlab.articulos.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.articulos.model.Articulo;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.repository.Repositorio;
import com.techlab.articulos.utils.ConsolaUtils;
import com.techlab.articulos.utils.Validaciones;

public abstract class Menu {

    protected Scanner scanner;
    protected List<OpcionMenu> opciones;
    protected Boolean continuarSolicitandoOpcion = Boolean.TRUE;
    protected Repositorio<Articulo> repositorioArticulos;
    protected Repositorio<Categoria> repositorioCategorias;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.opciones = new ArrayList<OpcionMenu>();
        this.repositorioArticulos = null;
        this.repositorioCategorias = null;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutarOpcion(int opcion);

    public void setContinuarSolicitandoOpcion(Boolean continuarSolicitandoOpcion) {
        this.continuarSolicitandoOpcion = continuarSolicitandoOpcion;
    }

    public Boolean getContinuarSolicitandoOpcion() {
        return continuarSolicitandoOpcion;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setRepositorioArticulos(Repositorio<Articulo> repositorioArticulos) {
        this.repositorioArticulos = repositorioArticulos;
    }

    public Repositorio<Articulo> getRepositorioArticulos() {
        return repositorioArticulos;
    }

    public void setRepositorioCategorias(Repositorio<Categoria> repositorioCategorias) {
        this.repositorioCategorias = repositorioCategorias;
    }

    public Repositorio<Categoria> getRepositorioCategorias() {
        return repositorioCategorias;
    }

    protected void listarOpcionesMenu(String titulo) {
        System.out.println(this.formatearTitulo(titulo));
        this.opciones.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

        if(!this.opciones.isEmpty() && this.opciones.size() > 1) {
            for (int i = 1; i < opciones.size(); i++) {
                System.out.println(opciones.get(i).getLeyendaMenu());
            }
        }
        System.out.println(this.opciones.get(0).getLeyendaMenu() + "\n");
    }

    protected String formatearTitulo(String titulo) {
        return ConsolaUtils.formatearTitulo(titulo);
    }

    protected OpcionMenu obtenerOpcionPorId(int id) {
        return this.opciones.stream().filter(opcion -> opcion.getId() == id).findFirst().orElse(null);
    }

    protected List<Integer> getOpcionesValidas() {
        return this.opciones.stream().map(OpcionMenu::getId).toList();
    }

    protected int leerOpcion() {
        boolean continuoPidiendoIngresoOpcion = true;
        int opcion = -1;

        do {
            opcion = leerEntero("Seleccione una opción: ");
            
            if(!Validaciones.esOpcionValida(opcion, this.getOpcionesValidas())){
                System.out.println("Opción no válida.");
            } else {
                continuoPidiendoIngresoOpcion = false;
            }

        } while (continuoPidiendoIngresoOpcion);

        return opcion;
    }

    protected int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            scanner.nextLine(); // Limpiar la entrada no válida
            System.out.print(mensaje);
        }
        int resultado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        return resultado;
    }

    protected double leerDouble(String mensaje){
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
            scanner.nextLine(); // Limpiar la entrada no válida
            System.out.print(mensaje);
        }
        double resultado = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        return resultado;
    }

    protected String leerTexto(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    protected boolean leerSiNo(String mensaje){
        System.out.print(mensaje + " (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        while (!respuesta.equals("s") && !respuesta.equals("n")) {
            System.out.println("Entrada no válida. Por favor, ingrese 's' para sí o 'n' para no.");
            System.out.print(mensaje + " (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
        }
        return respuesta.equals("s");
    }
}
