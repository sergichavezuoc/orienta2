
package view;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controlador.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Articulo;
import model.Cliente;
import view.VistaNuevoCliente;

public class VistaStore {
   
    
    
    
    
  
   public static void imprimeMenu() throws Exception{
       
       Controlador controlador = new Controlador();
       Scanner teclado = new Scanner(System.in); 
       boolean salir = false;
       int opcion;
        
       do {
            System.out.println("Introduzca una opcion");
            System.out.println(" 1: Gestion Articulos");
            System.out.println(" 2: Gestion Clientes ");
            System.out.println(" 3: Gestion Pedidos");
            System.out.println(" 4: Salir");
            
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1: controlador.gestionArticulos();
                    ;
                    break;
                case 2: VistaMenuCliente.gestionClientes();
                    ;
                    break;
                case 3: controlador.gestionPedidos();
                    ;
                    break; 
                case 4:
                    salir = true;                    
            }
        } while (!salir);
    }
   
   //ARTICULOS
   
  
 
 
   public static void mensajeCreado(boolean exito){
       if (exito) {
           System.out.println("Se ha podido crear correctamente.");
       } else {
            System.out.println("No se ha podido crear");
       }
   }
   
   

   
 
   
   
   
   
   
   
   //metodos lectura de teclado
   public static int obtenInt(){
       Scanner tecladoInt = new Scanner(System.in); 
       int numero=0;
       numero = Integer.parseInt(tecladoInt.nextLine());
       return numero;
       
   }
   
   public static String obtenString(){
       Scanner tecladoString = new Scanner(System.in);
       String cadena = tecladoString.nextLine();
       return cadena;
   }
   
   public static boolean obtenBoolean(){
       Scanner tecladoString = new Scanner(System.in);
       String cadena = tecladoString.nextLine();
       String cadenaSi= "Si";
       String cadenaNo= "No";
       if(cadena==cadenaSi){
           cadena="true";
       }else{
           cadena="false";
       }
       boolean bool = Boolean.valueOf(cadena);
       return bool;
   }

    public static void mensajeEliminado() {
        System.out.println("Se ha podido eliminar correctamente");
    }

    public static void mensajeError(String message) {
        System.out.println("Error!: " + message);
    }
   
}

   
   
    