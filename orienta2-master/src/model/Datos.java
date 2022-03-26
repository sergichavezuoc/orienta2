
package model;

import controlador.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Contendrá todos los datos de la aplicación y llevará a cabo todas las acciones que afectan a las mismas.
Este paquete contendrá las clases Datos, Cliente, ListaClientes así como el resto de clases necesarias
en la capa Modelo. 
*/



public class Datos {
        
    //llama a la funcion en la clase baseDatos para cargar los datos
    public static void cargarDatos(){
        BaseDatos.cargarDatos();
    }
     
    //INTRODUCIR DATOS
    
    //Introducir datos se invoca esta funcion en la vista que pasa al controlador y esta la devuelve a la vista
    //para que se introduzcan los datos y se guarde en un objeto que es pasado como parametro a introducirCliente
    public static boolean introducirArticulo(List<Object> atributos){
        
        Articulo articulo = new Articulo((Integer)atributos.get(0), atributos.get(1).toString(), 
                (Integer)atributos.get(2), (Integer)atributos.get(3), (Integer)atributos.get(4));
        
        //se agrega al arraylist de base de datos
        BaseDatos.agregarArticulo(articulo);
        //devuelve true si comprueba que el articulo esta en el arraylis de base de datos
        return BaseDatos.existeArticulo(articulo);
    }
    
    public static boolean introducirCliente(List<Object> atributos){
       
        
        boolean resultado= Boolean.valueOf((Boolean)atributos.get(4));
        //Si el cliente es premium
        if(resultado = true){
            ClientePremium clienteP = new ClientePremium(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString());
            BaseDatos.AgregarClientePremium(clienteP);
        //si el cliente es estandar
        }else{
             if(resultado = false){
            ClienteEstandar clienteE = new ClienteEstandar(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4));
            BaseDatos.AgregarClienteEstandar(clienteE);
        }    
    }
        //devuelve true si comprueba que el Cliente esta en la base de datos
        return true;
 }
    public static void introducirPedido(List<Object> atributos) throws ElementFound{
        
        Pedido pedido = new Pedido((Integer)atributos.get(0), (Cliente)atributos.get(1), (Articulo)atributos.get(2), (Integer)atributos.get(3),(LocalDateTime)atributos.get(4));
        
        if (BaseDatos.existePedido(pedido.getNumPedido())) {
            throw new ElementFound("Ya existe un elemento con ese identificador");
        }
        //se agrega al arraylist de base de datos
        BaseDatos.AgregarPedido(pedido);
    }
    
    
    //OBTENER LISTAS
    
    public static List ListarArticulos(){
    //cambiar a static para solucionar error
        List lista = ListaArticulos.obtenArticulos();
        return lista;       
    }
   
    public static List ListarPedidos(){
        List lista = ListaPedidos.obtenPedidos();
        return lista;
    }
    
    public static List ListarClientesP(){
        List lista = ListaClientes.obtenClientesP();
        return lista;
    }
    
    public static List ListarClientesE(){
        List lista = ListaClientes.obtenClientesE();
        return lista;
    }
    
    //Eliminar Datos
    public static void eliminarPedido(int pedido) throws ElementNotFound {
        BaseDatos.eliminarPedido(pedido);
    }
    
    // Recuperar cliente
    public static ClientePremium recuperarClientePremium(String email){
        ClientePremium cliente = BaseDatos.obtenClientesPremium(email);
        return cliente;
    }
    public static ClienteEstandar recuperarClienteEstandar(String email){
        ClienteEstandar cliente = BaseDatos.obtenClientesEstandar(email);
        return cliente;
    }
    
    public static Articulo recuperarArticulo(int codigoArticulo){
        Articulo articulo = BaseDatos.obtenArticulo(codigoArticulo);
        return articulo;
    }
}
