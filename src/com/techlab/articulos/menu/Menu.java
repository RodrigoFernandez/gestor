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

    protected void mostrarMenu(String titulo) {
        do {
            ConsolaUtils.limpiarConsola();
            
            this.listarOpcionesMenu(titulo);

            int opcionId = this.leerOpcion();

            this.ejecutarOpcion(opcionId);
        } while (this.continuarSolicitandoOpcion);
    }

    protected int leerEntero(String mensaje) {
        return ConsolaUtils.leerEntero(mensaje, this.scanner);
    }

    protected double leerDouble(String mensaje){
        return ConsolaUtils.leerDouble(mensaje, this.scanner);
    }

    protected String leerTexto(String mensaje){
        return ConsolaUtils.leerTexto(mensaje, this.scanner);
    }

    protected boolean leerSiNo(String mensaje){
        return ConsolaUtils.leerSiNo(mensaje, this.scanner);
    }
}
