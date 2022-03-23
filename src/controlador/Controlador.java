
package controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.*;
import java.sql.Connection;
import java.time.LocalDateTime;

public class Controlador {
    
    private  static VistaStore view;
    private static Datos controlerModel;
    private  int opcion = 0;

    public Controlador() {
    }
    
    public static void  cargarDatos() {
        
        Datos.cargarDatos();
    }
    
    public static void  mostrarMenuPrincipal() throws Exception{
        view.imprimeMenu();
    }

//ARTICULOS
    public  static void gestionArticulos() {
        VistaMenuArticulo.imprimeMenuArticulos();
    }


    public static void agregarArticulo() {
        boolean exito = true;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoArticulo.imprimeAgregarArticulo();
        Connection conn = null;
        new ArticuloDao(conn).save(new Articulo((Integer)atributos.get(0), atributos.get(1).toString(),(Integer)atributos.get(2), (Integer)atributos.get(3), (Integer)atributos.get(4))); 
        VistaStore.mensajeCreado(exito);
    }

    public static void  mostrarArticulos() {
        // Crear una array temporal para recibir articulos
        List lista = Datos.ListarArticulos();;
        // Llenar la array con los articulos
        // Llamar a la vista para mostrar los articulos
        VistaMostrarArticulo.muestraArticulos(lista);
    }
    public static Articulo recuperarArticulo(int codigoArticulo){
        Articulo articulo=Datos.recuperarArticulo(codigoArticulo);
        return articulo;
    }
    //PEDIDOS
        public static void agregarPedido() {
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoPedido.imprimeAgregarPedido();
        try {
            Datos.introducirPedido(atributos);
            Connection conn = null;
            new PedidoDao().save(new Pedido ((Integer)atributos.get(0), (Cliente)atributos.get(1), (Articulo)atributos.get(2), (Integer)atributos.get(3),(LocalDateTime)atributos.get(4))); 

            VistaStore.mensajeCreado(true);
        } catch (ElementFound e) {
            VistaStore.mensajeError(e.getMessage());
        }
    }
        public static void  mostrarPedidos() {
        // Crear una array temporal para recibir articulos
        List lista = Datos.ListarPedidos();
        // Llenar la array con los articulos
        // Llamar a la vista para mostrar los articulos
        VistaMuestraPedido.muestraPedidos(lista);
    }
        public static void eliminarPedido() {
        int pedido=VistaEliminarPedido.solicitarPedido();
        try {
            Datos.eliminarPedido(pedido);
            VistaStore.mensajeEliminado();
        } catch (ElementNotFound e) {
            VistaStore.mensajeError(e.getMessage());
        }
    }
    public static void agregarCliente(){
        boolean exito =true;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaNuevoCliente.imprimeAgregarCliente();
        Connection conn = null;
        if (atributos.get(4).equals("si")) {
        new ClienteDao(conn).save(new ClientePremium(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
        } else {
        new ClienteDao(conn).save(new ClienteEstandar(atributos.get(0).toString(), atributos.get(1).toString() , atributos.get(2).toString(), atributos.get(3).toString(), (Boolean)atributos.get(4)));
        }
        VistaStore.mensajeCreado(exito);
    }
    public static void mostrarClientes(){
        List lista = Datos.ListarClientesP();
        VistaMuestraCliente.muestraClientesP(lista);
        List lista2 = Datos.ListarClientesE();
        VistaMuestraCliente.muestraClientesE(lista2);
    }    
    public static void mostrarClientesP(){
        List lista = Datos.ListarClientesP();
        VistaMuestraCliente.muestraClientesP(lista);
    }
    public static void mostrarClientesE(){
        List lista = Datos.ListarClientesE();
        VistaMuestraCliente.muestraClientesE(lista);
    }
    
    public void gestionPedidos(){
        VistaMenuPedido.imprimeMenuPedidos();
    }
    public static ClientePremium recuperarCliente(String email){
        ClientePremium cliente=Datos.recuperarClientePremium(email);
        return cliente;
    }
    public static ClienteEstandar recuperarClienteE(String email){
        ClienteEstandar cliente=Datos.recuperarClienteEstandar(email);
        return cliente;
    }
}