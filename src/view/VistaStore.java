package view;

import controlador.*;
import java.util.Scanner;

public class VistaStore {

    

    public static void mensajeCreado(boolean exito) {
        if (exito) {
            System.out.println("Se ha podido crear correctamente.");
        } else {
            System.out.println("No se ha podido crear");
        }
    }

    //metodos lectura de teclado
    public static int obtenInt() {
        Scanner tecladoInt = new Scanner(System.in);
        int numero = 0;
        numero = Integer.parseInt(tecladoInt.nextLine());
        return numero;

    }

    public static Long obtenLong() {
        Scanner tecladoLong = new Scanner(System.in);
        Long numero = 0l;
        numero = Long.parseLong(tecladoLong.nextLine());
        return numero;
    }

    public static String obtenString() {
        Scanner tecladoString = new Scanner(System.in);
        String cadena = tecladoString.nextLine();
        return cadena;
    }

    public static boolean obtenBoolean() {
        Scanner tecladoString = new Scanner(System.in);
        String cadena = tecladoString.nextLine();
        if (cadena.equals("si")) {
            cadena = "true";
        } else {
            cadena = "false";
        }
        return Boolean.valueOf(cadena);
    }

    public static void mensajeEliminado() {
        System.out.println("Se ha podido eliminar correctamente");
    }

    public static void mensajeError(String message) {
        System.out.println("Error!: " + message);
    }

}
