
package controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.*;

public class Controlador {
    
    private  static VistaStore view;
    private static Datos controlerModel;
    private  int opcion = 0;


    
    public static void  cargarDatos() {
        
        Datos.cargarDatos();
    }
    
    public static void  mostrarMenuPrincipal() throws Exception{
        view.imprimeMenu();
    }

//ARTICULOS
    public  static void gestionArticulos() {
        view.imprimeMenuArticulos();
    }


    public static void agregarArticulo() {
        boolean exito = false;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaStore.imprimeAgregarArticulo();
        exito = Datos.introducirArticulo(atributos);
        VistaStore.mensajeCreado(exito);
    }

    public static void  mostrarArticulos() {
        // Crear una array temporal para recibir articulos
        List lista = Datos.ListarArticulos();;
        // Llenar la array con los articulos
        // Llamar a la vista para mostrar los articulos
        VistaStore.muestraArticulos(lista);
    }
    public static Articulo recuperarArticulo(int codigoArticulo){
        Articulo articulo=Datos.recuperarArticulo(codigoArticulo);
        return articulo;
    }
    //PEDIDOS
        public static void agregarPedido() {
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaStore.imprimeAgregarPedido();
        try {
            Datos.introducirPedido(atributos);
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
        VistaStore.muestraPedidos(lista);
    }
        public static void eliminarPedido() {
        int pedido=VistaStore.solicitarPedido();
        try {
            Datos.eliminarPedido(pedido);
            VistaStore.mensajeEliminado();
        } catch (ElementNotFound e) {
            VistaStore.mensajeError(e.getMessage());
        }
    }
    //CLIENTES

    public Controlador() {
    }
    
    
    public static void gestionClientes(){
        view.imprimeMenuClientes();
    }
    
    public static void agregarCliente(){
        boolean exito =false;
        List<Object> atributos = new ArrayList<Object>();
        atributos = VistaStore.imprimeAgregarCliente();
        exito = Datos.introducirCliente(atributos);
        VistaStore.mensajeCreado(exito);
    }
    public static void mostrarClientes(){
        List lista = Datos.ListarClientesP();
        view.muestraClientesP(lista);
        List lista2 = Datos.ListarClientesE();
        view.muestraClientesE(lista2);
    }    
    public static void mostrarClientesP(){
        List lista = Datos.ListarClientesP();
        view.muestraClientesP(lista);
    }
    public static void mostrarClientesE(){
        List lista = Datos.ListarClientesE();
        view.muestraClientesE(lista);
    }
    
    public void gestionPedidos(){
        view.imprimeMenuPedidos();
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