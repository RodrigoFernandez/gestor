package com.techlab.articulos.repository;

import java.util.ArrayList;
import java.util.List;

import com.techlab.articulos.interfaces.Identificable;

public class Repositorio<T extends Identificable> {

    private ArrayList<T> lista = new ArrayList<T>();

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public List<T> listar() {
        return lista;
    }

    public T buscarPorCodigo(Integer codigo) {
        for (T elemento : lista) {
            if (elemento.getCodigo().equals(codigo)) {
                return elemento;
            }
        }
        return null;
    }

    public T buscarPorNombre(String nombre) {
        for (T elemento : lista) {
            if (elemento.getNombre().equals(nombre)) {
                return elemento;
            }
        }
        return null;
    }

    public Boolean eliminar(Integer codigo) {
        T elementoAEliminar = buscarPorCodigo(codigo);
        if (elementoAEliminar != null) {
            lista.remove(elementoAEliminar);
            return true;
        }
        return false;
    }
    
    public boolean estaVacio() {
        return lista.isEmpty();
    }
}
