package controlador;

import java.util.List;
import model.*;
import view.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class Controlador {

    private static VistaStore view;
    private static Connection connection;

    public Controlador() {
        try {
            this.connection = DatabaseConnection.createConnection();

        } catch (SQLException e) {
            // TODO crear vista con System.out.println("Ha habido problema en la conexión");
        }
    }

 
    

//GESTION ARTICULOS


    public static boolean agregarArticulo(List atributos) {
        boolean exito = true;
        //List<Object> atributos = new ArrayList<Object>();
        //atributos = VistaNuevoArticulo.imprimeAgregarArticulo();
        try {
            if (new ArticuloDao(connection).save(new Articulo((Long) atributos.get(0), atributos.get(1).toString(), (Integer) atributos.get(2), (Integer) atributos.get(3), (Integer) atributos.get(4)))) {
                VistaStore.mensajeCreado(exito);
            }
        } catch (ElementFound ex) {
            exito = false;
            VistaStore.mensajeError(ex.getMessage());
        }
        return exito;
    }

    public static void mostrarArticulos(Stage primaryStage, MenuBar menuBar) throws SQLException {
        List lista = null;
        try {
            lista = new ArticuloDao(connection).getAll();
            VistaMostrarArticulo.muestraArticulos(lista, primaryStage, menuBar);
        } catch (ElementNotFound ex) {
            VistaStore.mensajeError(ex.getMessage());
        }
    }

    public static Articulo recuperarArticulo(String nombreArticulo) {
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


    public static boolean agregarPedido(List atributos) throws ElementFound, ElementNotFound {
        boolean exito;
        //List<Object> atributos = new ArrayList<Object>();
        //atributos = VistaNuevoPedido.imprimeAgregarPedido();
        if (new PedidoDao(connection).save(new Pedido((Long) atributos.get(0), (Cliente) atributos.get(1), (Articulo) atributos.get(2), (Integer) atributos.get(3), (Timestamp) atributos.get(4)))) {
            exito = true;
            VistaStore.mensajeCreado(exito);
        } else {
            exito = false;
        }

        return exito;
    }

    public static void mostrarPedidos(Stage primaryStage, MenuBar menuBar) {
        List lista;
        try {
            lista = new PedidoDao(connection).getAll();
            VistaMuestraPedido.muestraPedidos(lista, primaryStage, menuBar);
        } catch (ElementNotFound ex) {
            VistaStore.mensajeError("No se ha podido listar los pedidos");
        }
    }

    public static boolean eliminarPedido(Long pedido) throws ElementNotFound {
        boolean exito = false;
        exito = new PedidoDao(connection).delete(pedido);
        if (exito == true) {
            VistaStore.mensajeEliminado();
            exito = true;
        } else {
            VistaStore.mensajeError("No se ha podido eliminar");
            exito = false;
        }
        return exito;
    }

    //GESTION CLIENTES


    public static boolean agregarCliente(List atributos) {
        boolean exito;
        //List<Object> atributos = new ArrayList<Object>();
        //atributos = VistaNuevoCliente.imprimeAgregarCliente();
        if (atributos.get(4).equals(true)) {
            exito = new ClienteDao(connection).save(new ClientePremium(atributos.get(0).toString(), atributos.get(1).toString(),
                    atributos.get(2).toString(), atributos.get(3).toString(), (Boolean) atributos.get(4)));
        } else {
            exito = new ClienteDao(connection).save(new ClienteEstandar(atributos.get(0).toString(), atributos.get(1).toString(),
                    atributos.get(2).toString(), atributos.get(3).toString(), (Boolean) atributos.get(4)));
        }
        //VistaStore.mensajeCreado(exito);
        return exito;
    }

    public static void mostrarClientes(Stage primaryStage, MenuBar menuBar) {
        List lista = new ClienteDao(connection).getAll();
        VistaMuestraCliente.muestraClientes(lista, primaryStage, menuBar);
    }

    public static void mostrarClientesP(Stage primaryStage, MenuBar menuBar) {
        List lista = new ClienteDao(connection).getAllPremium();
        VistaMuestraCliente.muestraClientesP(lista, primaryStage, menuBar);
    }

    public static void mostrarClientesE(Stage primaryStage, MenuBar menuBar) {
        List lista = new ClienteDao(connection).getAllEstandar();
        VistaMuestraCliente.muestraClientesE(lista, primaryStage, menuBar);
    }

    public static Cliente recuperarCliente(String email) throws ElementNotFound {
        Cliente cliente = new ClienteDao(connection).get(email);
        return cliente;
    }
}
