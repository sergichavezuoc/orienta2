/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controlador.Controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static view.VistaStore.obtenBoolean;
import static view.VistaStore.obtenString;

/**
 *
 * @author sergichavez
 */
public class VistaMenuCliente {
     public static void gestionClientes(){
        imprimeMenuClientes();
    }  
      public static void imprimeMenuClientes(){
       Controlador controlador = null;
       Scanner teclado3 = new Scanner(System.in); 
       boolean salir = false;
       int opcion3;
        
       do {
            System.out.println("Introduzca una opcion");
            System.out.println(" 1: Introducir cliente nuevo");
            System.out.println(" 2: Mostrar listado clientes ");
            System.out.println(" 3: Mostrar listado clientes premium ");
            System.out.println(" 4: Mostrar listado clientes estandar");
            System.out.println(" 5: Volver al menu inicial");
            
            opcion3= teclado3.nextInt();

            switch (opcion3) {

                case 1: controlador.agregarCliente();
                    ;
                    break;
                case 2: controlador.mostrarClientes();
                    ;
                    break;
                case 3: controlador.mostrarClientesP();
                    ;
                    break;
                case 4: controlador.mostrarClientesE(); 
                    ;
                    break; 
                case 5:
                    salir = true;                    
            }
        } while (!salir);
    }  
   
}
