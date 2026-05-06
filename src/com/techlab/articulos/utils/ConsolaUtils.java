package com.techlab.articulos.utils;

import java.util.Scanner;

public final class ConsolaUtils {

    public static String formatearTitulo(String titulo) {
        return "\n" + titulo + ":\n" + "-".repeat(titulo.length() + 1);
    }

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

    public static void esperarEnterParaContinuar(Scanner sc) {
        System.out.println("\nPresione enter para continuar...");
        sc.nextLine();
    }

    public static int leerEntero(String mensaje, Scanner sc) {
        System.out.print(mensaje);
        
        while (!sc.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            sc.nextLine(); // Limpiar la entrada no válida
            System.out.print(mensaje);
        }

        int resultado = sc.nextInt();
        sc.nextLine(); // Limpiar el salto de línea
        return resultado;
    }

    public static double leerDouble(String mensaje, Scanner sc){
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
            sc.nextLine(); // Limpiar la entrada no válida
            System.out.print(mensaje);
        }
        double resultado = sc.nextDouble();
        sc.nextLine(); // Limpiar el salto de línea
        return resultado;
    }

    public static String leerTexto(String mensaje, Scanner sc) {
        System.out.print(mensaje);
        String resultado;

        do {
            resultado = sc.nextLine().trim();
        } while (resultado.isEmpty());

        return resultado;
    }

    public static boolean leerSiNo(String mensaje, Scanner sc) {
        System.out.print(mensaje + " (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();
        while (!respuesta.equals("s") && !respuesta.equals("n")) {
            System.out.println("Entrada no válida. Por favor, ingrese 's' para sí o 'n' para no.");
            System.out.print(mensaje + " (s/n): ");
            respuesta = sc.nextLine().trim().toLowerCase();
        }
        return respuesta.equals("s");
    }
}
