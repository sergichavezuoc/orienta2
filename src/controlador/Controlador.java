
package controlador;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Controlador {
    
    private  static VistaStore view;
    private static Datos controlerModel;
    private  int opcion = 0;
    private  static Connection connection;

    public Controlador() {
        try {
            this.connection = DatabaseConnection.createConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet res = stmt.executeQuery();
            res.next();
            System.out.println(res.getString("nombre"));
            
        } catch (SQLException e) {
            // TODO crear vista con System.out.println("Ha habido problema en la conexión");
        }
    }
    
    public void cargarDatos() {
        Datos.cargarDatos();
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
        if(new ArticuloDao(connection).save(new Articulo((Integer)atributos.get(0), atributos.get(1).toString(),(Integer)atributos.get(2), (Integer)atributos.get(3), (Integer)atributos.get(4)))){
            exito = true;
        } 
        VistaStore.mensajeCreado(exito);
    }

    public static void  mostrarArticulos() throws SQLException {
        List lista = new ArticuloDao(connection).getAll();
        VistaMostrarArticulo.muestraArticulos(lista);
    }
    public static Articulo recuperarArticulo(String nombreArticulo){
        Articulo articulo = new ArticuloDao(connection).getArticulo(nombreArticulo);
        return articulo;
    }
    
    //GESTION PEDIDOS
    
    public void agregarPedido() {
        boolean exito;    
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoPedido.imprimeAgregarPedido();
        if(new PedidoDao(connection).save(new Pedido ((Integer)atributos.get(0), (Cliente)atributos.get(1), (Articulo)atributos.get(2), (Integer)atributos.get(3),(LocalDateTime)atributos.get(4)))){
            exito = true;
            VistaStore.mensajeCreado(exito);
        } 

    }
        public void  mostrarPedidos() {
        // Crear una array temporal para recibir articulos
        List lista = new PedidoDao(connection).getAll();
        VistaMuestraPedido.muestraPedidos(lista);    
    }
        public void eliminarPedido() {
        int pedido=VistaEliminarPedido.solicitarPedido();
        try {
            Datos.eliminarPedido(pedido);
            VistaStore.mensajeEliminado();
        } catch (ElementNotFound e) {
            VistaStore.mensajeError(e.getMessage());
        }
    }     
     
    //GESTION CLIENTES
        
    public void gestionPedidos(){
        VistaMenuPedido.imprimeMenuPedidos();
    }
    public void agregarCliente(){
        boolean exito =true;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoCliente.imprimeAgregarCliente();
        if (atributos.get(4).equals(true)) {
        new ClienteDao(connection).save(new ClientePremium(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
        } else {
        new ClienteDao(connection).save(new ClienteEstandar(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
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

    public static Cliente recuperarCliente(String email){
        Cliente cliente= new ClienteDao(connection).get(email);
        return cliente;
    }
}