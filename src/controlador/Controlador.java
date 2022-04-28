
package controlador;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;



public class Controlador {
    
    private  static VistaStore view;
    private  static Connection connection;

    public Controlador() {
        try {
            this.connection = DatabaseConnection.createConnection();
         
        } catch (SQLException e) {
            // TODO crear vista con System.out.println("Ha habido problema en la conexión");
        }
    }
    
    public void  mostrarMenuPrincipal() throws Exception{
        view.imprimeMenu();
    }

//GESTION ARTICULOS
    
    public  static void gestionArticulos() throws SQLException {
        VistaMenuArticulo.imprimeMenuArticulos();
    }

    public void agregarArticulo() {
        boolean exito = true;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoArticulo.imprimeAgregarArticulo();
        try {
            if(new ArticuloDao(connection).save(new Articulo((Long)atributos.get(0), atributos.get(1).toString(),(Integer)atributos.get(2), (Integer)atributos.get(3), (Integer)atributos.get(4)))){
               VistaStore.mensajeCreado(exito);
            }        
        } catch (ElementFound ex) {
            VistaStore.mensajeError(ex.getMessage());
        }
    }

    public static void  mostrarArticulos() throws SQLException {
        List lista = null;
        try {
            lista = new ArticuloDao(connection).getAll();
            VistaMostrarArticulo.muestraArticulos(lista);
        } catch (ElementNotFound ex) {
            VistaStore.mensajeError(ex.getMessage());
        }
    }
    
    public static Articulo recuperarArticulo(String nombreArticulo){
        Articulo articulo;
        try {
            articulo = new ArticuloDao(connection).getArticulo(nombreArticulo);
            return articulo;
        } catch (ElementNotFound ex) {
            VistaStore.mensajeError(ex.getMessage());
        }
        return null;
    }
    
    //GESTION PEDIDOS
    
    public void gestionPedidos() throws ElementFound, ElementNotFound{
        VistaMenuPedido.imprimeMenuPedidos();
    }
    
    public void agregarPedido() throws ElementFound, ElementNotFound {
        boolean exito;    
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoPedido.imprimeAgregarPedido();
        if(new PedidoDao(connection).save(new Pedido ((Long)atributos.get(0), (Cliente)atributos.get(1), (Articulo)atributos.get(2), (Integer)atributos.get(3),(Timestamp)atributos.get(4)))){
            exito = true;
            VistaStore.mensajeCreado(exito);
        } 

    }
    
    public void  mostrarPedidos() {
        List lista;
        try {
            lista = new PedidoDao(connection).getAll();
            VistaMuestraPedido.muestraPedidos(lista);    
        } catch (ElementNotFound ex) {
            VistaStore.mensajeError("No se ha podido listar los pedidos");
        }
    }
        
    public void eliminarPedido() throws ElementNotFound {
        Long pedido = VistaEliminarPedido.solicitarPedido();
        boolean exito =false;
        exito = new PedidoDao(connection).delete(pedido);
        if (exito==true){
            VistaStore.mensajeEliminado();
        }else{
            VistaStore.mensajeError("No se ha podido eliminar");
        }
    }     
     
    //GESTION CLIENTES
        
    public  static void gestionClientes() throws SQLException {
        VistaMenuCliente.imprimeMenuClientes();
    }
    
    public void agregarCliente(){
        boolean exito;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoCliente.imprimeAgregarCliente();
        if (atributos.get(4).equals(true)) {
        exito = new ClienteDao(connection).save(new ClientePremium(atributos.get(0).toString(), atributos.get(1).toString() , 
                atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
        } else {
        exito = new ClienteDao(connection).save(new ClienteEstandar(atributos.get(0).toString(), atributos.get(1).toString() ,
                atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
        }
        VistaStore.mensajeCreado(exito);
    }
    
    public static void mostrarClientes(){
        List lista = new ClienteDao(connection).getAll();
        VistaMuestraCliente.muestraClientes(lista);
    }    
    
    public static void mostrarClientesP(){
        List lista = new ClienteDao(connection).getAllPremium();
        VistaMuestraCliente.muestraClientesP(lista);
    }
    
    public static void mostrarClientesE(){
        List lista = new ClienteDao(connection).getAllEstandar();
        VistaMuestraCliente.muestraClientesE(lista);
    }

    public static Cliente recuperarCliente(String email) throws ElementNotFound{
        Cliente cliente= new ClienteDao(connection).get(email);
        return cliente;
    }
}