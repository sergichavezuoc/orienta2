
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
                case 2: controlador.gestionClientes();
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
   
   public static void imprimeMenuArticulos(){
       Controlador controlador = new Controlador();
       Scanner teclado2 = new Scanner(System.in); 
       boolean salir = false;
       int opcion2;
        
       do {
            System.out.println("Introduzca una opcion");
            System.out.println(" 1: Introducir articulo nuevo");
            System.out.println(" 2: Mostrar listado articulos ");
            System.out.println(" 3: Eliminar articulo");
            System.out.println(" 4: Volver al menu inicial");
            
            opcion2= teclado2.nextInt();

            switch (opcion2) {

                case 1: controlador.agregarArticulo();
                    ;
                    break;
                case 2: controlador.mostrarArticulos();
                    ;
                    break;
                case 3:  
                    ;
                    break; 
                case 4:
                    salir = true;                    
            }
        }
       while (!salir);
    }  
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
        public static List imprimeAgregarPedido(){
       //int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos
       int numPedido, cantidad;
       Cliente cliente;
       Articulo articulo;
       Date fecha;
       Time hora;
       String email;
       List<Object> atributos = new ArrayList<Object>();
       
       System.out.println("Introduce el un nº entero correspondiente al codigo del pedido");
       numPedido = obtenInt();
       atributos.add(numPedido);
       System.out.println("Cliente premium si o no");
       String respuesta=obtenString();
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       if (respuesta.equals("si")) {cliente = Controlador.recuperarCliente(email);}
       else {cliente = Controlador.recuperarClienteE(email);};
       atributos.add(cliente);
       System.out.println("Introduce el codigo del articulo");
       int codigoArticulo = obtenInt();
       articulo = Controlador.recuperarArticulo(codigoArticulo);
       atributos.add(articulo);
       System.out.println("Introduce cantidad");
       cantidad = obtenInt();
       atributos.add(cantidad);
       LocalDateTime date = LocalDateTime.now();
       atributos.add(date);
       System.out.println("fecha fijada");
       return atributos;    
        
   }
   public static List imprimeAgregarArticulo(){
       //int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos
       int numArticulo, precio, gastos, tiempoMinutos;
       String descripcion;
       List<Object> atributos = new ArrayList<Object>();
       
       System.out.println("Introduce el un nº entero correspondiente al codigo del articulo");
       numArticulo = obtenInt();
       atributos.add(numArticulo);
       System.out.println("Introduce una descripcion del articulo");
       descripcion = obtenString();
       atributos.add(descripcion);
       System.out.println("Introduce un nº entero para el precio del articulo");
       precio = obtenInt();
       atributos.add(precio);
       System.out.println("Introduce el un nº entero para los gastos de envio");
       gastos = obtenInt();
       atributos.add(gastos);
       System.out.println("Introduce el un nº entero para la elaboracion del articulo en minutos");
       tiempoMinutos = obtenInt();
       atributos.add(tiempoMinutos);
       return atributos;    
        
   }
   public static int solicitarPedido(){
      System.out.println("Introduce el un nº entero del pedido a eliminar");
      int pedido = obtenInt();
      return pedido;
   }
   public static void mensajeCreado(boolean exito){
       if (exito) {
           System.out.println("Se ha podido crear correctamente.");
       } else {
            System.out.println("No se ha podido crear");
       }
   }
   
   public static void muestraArticulos(List lista){
        System.out.println("Lista de articulos guardados");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }
   //PEDIDOS
      public static void muestraPedidos(List lista){
        System.out.println("Lista de pedidos guardados");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }
   
   //CLIENTES
   public static void muestraClientesP(List lista){
        System.out.println("Lista de clientes Premium");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }
   public static void muestraClientesE(List lista){
        System.out.println("Lista de clientes NO Premium");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
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
   
   public static List imprimeAgregarCliente(){
       //String nombre, String domicilio, String nif, String email
       String nombre, domicilio, nif, email;
       boolean premium;
       List<Object> atributos = new ArrayList<Object>();
       
       System.out.println("Introduce el nombre del cliente");
       nombre = obtenString();
       atributos.add(nombre);
       System.out.println("Introduce el domicilio del cliente");
       domicilio = obtenString();
       atributos.add(domicilio);
       System.out.println("Introduce el NIF del cliente");
       nif = obtenString();
       atributos.add(nif);
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       atributos.add(email);
       System.out.println("¿El cliente es premium? Responda si o no");
       premium = obtenBoolean();
       atributos.add(premium);
       return atributos;    
        
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

   
   
    