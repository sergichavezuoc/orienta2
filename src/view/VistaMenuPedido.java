/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.util.Scanner;

/**
 *
 * @author sergichavez
 */
public class VistaMenuPedido {
   //MENU PEDIDOS
     public static void imprimeMenuPedidos(){
       Controlador controlador = new Controlador();
       Scanner teclado2 = new Scanner(System.in); 
       boolean salir = false;
       int opcion2;
        
       do {
            System.out.println("Introduzca una opcion");
            System.out.println(" 1: Introducir un pedido");
            System.out.println(" 2: Mostrar listado pedidos ");
            System.out.println(" 3: Eliminar pedido");
            System.out.println(" 4: Volver al menu inicial");
            
            opcion2= teclado2.nextInt();

            switch (opcion2) {

                case 1: controlador.agregarPedido();
                    ;
                    break;
                case 2: controlador.mostrarPedidos();
                    ;
                    break;
                case 3: controlador.eliminarPedido(); 
                    ;
                    break; 
                case 4:
                    salir = true;                    
            }
        }
       while (!salir);
    }
     
}
