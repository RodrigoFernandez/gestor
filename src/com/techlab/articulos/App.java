package com.techlab.articulos;

import java.util.Scanner;

import com.techlab.articulos.menu.Menu;
import com.techlab.articulos.menu.MenuArticulos;
import com.techlab.articulos.menu.MenuCategorias;
import com.techlab.articulos.menu.MenuPrincipal;
import com.techlab.articulos.menu.OpcionMenu;
import com.techlab.articulos.menu.acciones.AccionMostrarMenuArticulos;
import com.techlab.articulos.menu.acciones.AccionMostrarMenuCategorias;
import com.techlab.articulos.model.Articulo;
import com.techlab.articulos.model.Categoria;
import com.techlab.articulos.repository.Repositorio;

public class App {

    private static Menu getMenuArticulos(Scanner sc, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategorias) {
        Menu menuArticulos = new MenuArticulos(sc);
        menuArticulos.setRepositorioArticulos(repositorioArticulos);
        menuArticulos.setRepositorioCategorias(repositorioCategorias);
        return menuArticulos;
    }

    private static Menu getMenuCategorias(Scanner sc, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategorias) {
        Menu menuCategorias = new MenuCategorias(sc);
        menuCategorias.setRepositorioArticulos(repositorioArticulos);
        menuCategorias.setRepositorioCategorias(repositorioCategorias);
        return menuCategorias;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Repositorio<Articulo> repositorioArticulos = new Repositorio<Articulo>();
        Repositorio<Categoria> repositorioCategorias = new Repositorio<Categoria>();

        Menu menuArticulos = getMenuArticulos(sc, repositorioArticulos, repositorioCategorias);
        Menu menuCategorias = getMenuCategorias(sc, repositorioArticulos, repositorioCategorias);

        MenuPrincipal menuPrincipal = new MenuPrincipal(sc);
        menuPrincipal.agregarOpcionMenu(new OpcionMenu(1, "Menú Articulos", new AccionMostrarMenuArticulos(menuArticulos)));
        menuPrincipal.agregarOpcionMenu(new OpcionMenu(2, "Menú Categorias", new AccionMostrarMenuCategorias(menuCategorias)));

        menuPrincipal.mostrarMenu();
    }
}
