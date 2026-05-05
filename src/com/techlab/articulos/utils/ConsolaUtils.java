package com.techlab.articulos.utils;

public final class ConsolaUtils {

    public static void limpiarConsola() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static String formatearTitulo(String titulo) {
        return "\n" + titulo + ":\n" + "-".repeat(titulo.length() + 1);
    }
}
