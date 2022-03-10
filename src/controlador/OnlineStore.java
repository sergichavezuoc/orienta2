/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import view.*;
import model.*;

/**
 *
 * @author sergichavez
 */
public class OnlineStore {

    Scanner sn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OnlineStore prg = new OnlineStore();
        /*
       Llamada a inicio sin parámetros para incializar el programa
         */
        prg.inicio();
    }

    void inicio() {
        boolean salir = false;
        char opcio;
        do {
            /*
            llamada a la funcion texto_menu, no requiere parametros y muestra
            las opciones al usuario
             */
            MenuView.texto_menu();
            /*
            pedirOpcion(), sin parametros y pide al usuario que elija la opcion
            del menu que quiere ejecutar
             */
            opcio = pedirOpcion();
            // mostramos opcion elegida por el usuario
            System.out.println("Opcion: " + opcio);
            switch (opcio) {

                case '1':
                    /*
                    funcion para entrar clientes
                     */
                    System.out.println("Opcion para entrar clientes");
                    break;
                case '2':
                    /*
                    funcion para entrar articulos
                     */
                    System.out.println("Opcion para entrar articulos");
                    break;
                case '3':
                    /*
                    funcion para entrar pedidos
                     */
                    System.out.println("Opcion para entrar pedidos");
                    break;
                case '4':
                    /*
                    funcion para mostrar clientes
                     */
                    System.out.println("Opcion para mostrar clientes\n\n");
                    Clientes model = retriveClientePremiumFromDatabase();
                    ClientesView view = new ClientesView();
                    controlador controller = new controlador(model, view);
                    controller.updateViewCliente();
                    break;
                case '5':
                    /*
                    funcion para mostrar articulos
                     */
                    System.out.println("Opcion para mostrar articulos\n\n");
                    Articulos modelArticulo = retriveArticulosFromDatabase();
                    ArticulosView viewArticulo = new ArticulosView();
                    controlador controllerArticulo = new controlador(modelArticulo, viewArticulo);
                    controllerArticulo.updateViewArticulo();
                    break;
                case '6':
                    /*
                    funcion para mostrar pedidos
                     */
                    System.out.println("Opcion para mostrar pedidos");
                    break;
                case '7':
                    /*
                    funcion para eliminar pedidos
                     */
                    System.out.println("Opcion para eliminar pedidos");
                    break;
                case '8':
                    salir = true;
            }
        } while (!salir);

        //"supuesta" carga de datos en base de datos
    }

    private static Clientes retriveClienteFromDatabase() {
        ClientesNoPremium cliente = new ClientesNoPremium("Robert","Calle Serrano","222233332X","juaito@uoc.edu");
        return cliente;
    }
    private static Clientes retriveClientePremiumFromDatabase() {
        ClientesPremium cliente = new ClientesPremium("Roberto","Calle Mariano","333333332X","manolo@uoc.edu");
        return cliente;
    }


    private static Articulos retriveArticulosFromDatabase() {
        Articulos articulo = new Articulos();
        articulo.setNumArticulo(01);
        articulo.setDescripcion("Dibujo matematico loco");
        articulo.setPrecio(100000000);
        articulo.setGastos(3);
        articulo.setTiempoMinutos(30);
        return articulo;
    }

    char pedirOpcion() {
        /* metodo para elegir la opción deseada del menu*/
        String resp;
        resp = sn.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

}
