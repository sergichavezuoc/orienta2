
package model;

import java.util.ArrayList;
import java.lang.reflect.Array;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


public class BaseDatos {
  
    private static ArrayList <Articulo> articulos = new ArrayList<>();
    private static ArrayList <Pedido> pedidos = new ArrayList<>();
    private static ArrayList <Cliente> clientes = new ArrayList<>();
    private static ArrayList <ClienteEstandar> clienteEstandar = new ArrayList<>();
    private static ArrayList <ClientePremium> clientePremium = new ArrayList<>();
      
    
  //Agregar articulos
    
    public static void agregarArticulo(Articulo articulo){    
        articulos.add(articulo);       
    }
  
    //Obtener articulos por su codigo
    
    public static Articulo encuentraArticulo(String codigo){        
        Articulo articuloEncontrado = articulos.stream().filter(elemento -> codigo.equals( elemento.getNumArticulo())).findFirst().orElse(null);;   
        return articuloEncontrado;       
    }
    
    //Obten articulos del arraylist devuelta en forma de List
   
    public static List obtenArticulos(){       
        return articulos;
    }
    
    //Comprobar si existe articulo
    public static boolean existeArticulo(Articulo articuloIntroducido ){
        return obtenArticulos().contains(articuloIntroducido);
    }
    
      //Comprobar si existe pedido introducido
    public static boolean existePedido(int numPedido){
        return obtenPedidos()
                .stream()
                .map(pedido -> pedido.getNumPedido())
                .anyMatch(numPedido2 -> numPedido2 == numPedido);
    }  
    //Obtener clientes
    
    public static List obtenClientesP(){
        return clientePremium;
    }
    
    public static List obtenClientesE(){
        return clienteEstandar;
    }
    public static void eliminarPedido(int pedido) throws ElementNotFound {
        Pedido pedidoEliminar = pedidos.stream()
                .filter(elemento -> pedido==elemento.getNumPedido())
                .findFirst()
                .orElse(null);
        if (pedidoEliminar!=null && esEliminable(pedidoEliminar))
        {
            pedidos.remove(pedidoEliminar);
            
        } else 
        {
            throw new ElementNotFound("No se ha encontrado el pedido con el identificador introducido.");
        }
    }
    
    private static boolean esEliminable(Pedido pedido) {
        return pedido.getArticulo().getTiempoMinutos() > ChronoUnit.MINUTES.between(pedido.getFecha(), LocalDateTime.now());
    }
    
    public static ClientePremium obtenClientesPremium(String email){
        ClientePremium clientePremiumEncontrado = clientePremium.stream().filter(elemento -> email.equals( elemento.getEmail())).findFirst().orElse(null);;   
        return clientePremiumEncontrado;  
    }
     public static ClienteEstandar obtenClientesEstandar(String email){
        ClienteEstandar clienteEncontrado = clienteEstandar.stream().filter(elemento -> email.equals( elemento.getEmail())).findFirst().orElse(null);;   
        return clienteEncontrado;  
    }
    public static Articulo obtenArticulo(int codigoArticulo){
      
        Articulo articuloEncontrado = articulos.stream().filter(elemento -> codigoArticulo==( elemento.getNumArticulo())).findFirst().orElse(null);;   
        return articuloEncontrado;  
    }
    //Agregar cliente premium
    
    public static void AgregarClientePremium(ClientePremium clienteP){
        clientePremium.add(clienteP);
    }
    //Agregar cliente estandar
    public static void AgregarClienteEstandar(ClienteEstandar clienteE){
        clienteEstandar.add(clienteE);
    }
    
    //Comprobar si existe cliente
    
    //Agregar pedido
    public static void AgregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    
    //Obtener pedidos
    
    public static List<Pedido> obtenPedidos(){
        return pedidos;
    }
    
    //Cargar datos
    
    public static void cargarDatos(){
        
        ClienteEstandar clienteE;
        ClientePremium clienteP;
        Pedido pedido;
        Articulo articulo;
        
        //int numPedido, Cliente cliente, Articulo articulo, int cantidad, Date fecha, Time hora
        
        //int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos
        articulo = new Articulo(1, "coche de juguete", 5, 3, 60);
        clienteE = new ClienteEstandar("Sergi", "Barcelona", "11111", "sergi@sergi.sergi", false);
        pedido = new Pedido(1, clienteE, articulo, 2, LocalDateTime.of(2022, Month.JANUARY, 23, 16, 12));
        clienteEstandar.add(clienteE);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(2, "videojuego", 50, 3, 30);
        clienteE = new ClienteEstandar("Renata", "Madrid", "22222", "renata@renata.renata", false);        
        pedido = new Pedido(2, clienteE, articulo, 1, LocalDateTime.of(2022, Month.JANUARY, 23, 11, 7) );
        clienteEstandar.add(clienteE);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(3, "vinilo", 30, 3, 60);
        clienteE = new ClienteEstandar("Raquel", "Burgos", "33333", "raquel@raquel.raquel", false);
        pedido = new Pedido(3, clienteE, articulo, 2, LocalDateTime.of(2022, Month.JANUARY, 23, 8, 5) );
        clienteEstandar.add(clienteE);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(4, "florero", 35, 5, 60);
        clienteE = new ClienteEstandar("Sonia", "Valencia", "44444", "sonia@sonia.sonia", false);
        pedido = new Pedido(4, clienteE, articulo, 1, LocalDateTime.of(2022, Month.FEBRUARY, 7, 11, 10) );       
        clienteEstandar.add(clienteE);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(5, "armario", 200, 10, 120);
        clienteE = new ClienteEstandar("Mario", "Aturias", "55555", "mario@mario.mario",false);
        pedido = new Pedido(5, clienteE, articulo, 1, LocalDateTime.of(2022, Month.FEBRUARY, 7, 18, 10) );       
        clienteEstandar.add(clienteE);
        articulos.add(articulo);
        pedidos.add(pedido);
        
        articulo = new Articulo(6, "television", 1000, 10, 120);        
        clienteP = new ClientePremium("Veronica", "Cadiz", "66666", "veronica@veronica.veronica", true);
        pedido = new Pedido(6, clienteP, articulo, 1, LocalDateTime.of(2022, Month.FEBRUARY, 7, 20, 10) );      
        clientePremium.add(clienteP);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(7, "ipad", 1300, 0, 60);   
        clienteP = new ClientePremium("Paco", "Murcia", "77777", "paco@paco.paco", true);
        pedido = new Pedido(7, clienteP, articulo, 1, LocalDateTime.of(2022, Month.FEBRUARY, 7, 15, 15) );
        clientePremium.add(clienteP);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(8, "Cascos inalambricos", 50, 3, 60);  
        clienteP = new ClientePremium("Patri", "Granada", "888888", "patri@patri.patri", true);
        pedido = new Pedido(8, clienteP, articulo, 1, LocalDateTime.of(2022, Month.FEBRUARY, 7, 7, 11) );       
        clientePremium.add(clienteP);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(9, "Poster", 20, 1, 30);
        clienteP = new ClientePremium("Irene", "Barcelona", "99999", "irene@irene.irene", true);
        pedido = new Pedido(9, clienteP, articulo, 1, LocalDateTime.of(2022, Month.MARCH, 12, 12, 16) );          
        clientePremium.add(clienteP);
        articulos.add(articulo);
        pedidos.add(pedido);
        articulo = new Articulo(10, "Tocadiscos", 150, 1, 30);
        clienteP = new ClientePremium("Izan", "Mallorca", "11112", "izan@izan.izan", true);
        pedido = new Pedido(10, clienteP, articulo, 1, LocalDateTime.of(2022, Month.MARCH, 12, 18, 20) );     
        clientePremium.add(clienteP);
        articulos.add(articulo);
        pedidos.add(pedido);
        
        
    }
    
}
