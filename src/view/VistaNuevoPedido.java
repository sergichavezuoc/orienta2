/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Articulo;
import model.Cliente;
import model.ArticuloDao;
import model.ClienteDao;
import model.ElementFound;
import model.ElementNotFound;

/**
 *
 * @author sergichavez
 */
public class VistaNuevoPedido {

    private static Connection connection;

    public static void imprimeAgregarPedido(Stage primaryStage, MenuBar menuBar) throws ElementNotFound {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Formulario de entrada de pedidos");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 2, 2, 1);
        Label numero = new Label("Numero de pedido:");
        grid.add(numero, 0, 3);
        TextField numeroTextField = new TextField();
        grid.add(numeroTextField, 1, 3);

        Label cliente = new Label("Cliente:");
        grid.add(cliente, 0, 4);
//TextField  clienteTextField= new TextField();
//grid.add(clienteTextField, 1, 2);
        List listaclientes = new ClienteDao(connection).getAll();
        ComboBox clientesBox = new ComboBox();
        for (int i = 0; i < listaclientes.size(); i++) {
            Cliente clientes = (Cliente) listaclientes.get(i);
            clientesBox.getItems().addAll(clientes.getEmail());
        }
        grid.add(clientesBox, 1, 4);
        Label articulo = new Label("Articulo:");
        grid.add(articulo, 0, 5);
//TextField  articuloTextField= new TextField();
//grid.add(articuloTextField, 1, 3);
        List lista = new ArticuloDao(connection).getAll();
        ComboBox articulosBox = new ComboBox();
        for (int i = 0; i < lista.size(); i++) {
            Articulo articulos = (Articulo) lista.get(i);
            articulosBox.getItems().addAll(articulos.getDescripcion());
        }
        grid.add(articulosBox, 1, 5);
        Label cantidad = new Label("Cantidad:");
        grid.add(cantidad, 0, 6);
        TextField cantidadTextField = new TextField();
        grid.add(cantidadTextField, 1, 6);
        Button btn = new Button("Entrar Pedido");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 9);
        VBox vBox = new VBox(menuBar, grid);
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<Object> atributos = new ArrayList<Object>();
                atributos.add(Long.parseLong(numeroTextField.getText()));
                Cliente clienteElegido = null;
                try {
                    clienteElegido = Controlador.recuperarCliente((String) clientesBox.getValue());
                } catch (ElementNotFound ex) {
                    Logger.getLogger(VistaNuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                atributos.add(clienteElegido);
                Articulo articuloElegido = null;
                articuloElegido = Controlador.recuperarArticulo((String) articulosBox.getValue());
                atributos.add(articuloElegido);
                atributos.add(Integer.parseInt(cantidadTextField.getText()));
                Timestamp date = Timestamp.valueOf(LocalDateTime.now());
                atributos.add(date);
                boolean exito;
                exito = false;
                try {
                    exito = Controlador.agregarPedido(atributos);
                } catch (ElementFound ex) {
                    Logger.getLogger(VistaNuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ElementNotFound ex) {
                    Logger.getLogger(VistaNuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (exito == true) {
                    GridPane grid = new GridPane();
                    grid.setAlignment(Pos.CENTER);
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
                    Text scenetitle = new Text("Pedido incorporado");
                    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
                    grid.add(scenetitle, 0, 0, 2, 1);
                    Label nombre = new Label("El articulo se ha introducido");
                    grid.add(nombre, 0, 1);
                    VBox vBox = new VBox(menuBar, grid);
                    vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
                    primaryStage.getScene().setRoot(vBox);
                };
            }
        });
        //actiontarget.setText(nifTextField.getText());

        /*
       int  cantidad;
       Long numPedido;
       Cliente cliente;
       String nif, nombreArticulo;
       Articulo articulo;
       Date fecha;
       Time hora;
       String email;
       List<Object> atributos = new ArrayList<Object>();
       System.out.println("###########################");
       System.out.println("  FORMULARIO NUEVO PEDIDO  ");
       System.out.println("###########################");       
       System.out.println("Introduce el un nº entero correspondiente al codigo del pedido");
       numPedido = obtenLong();
       System.out.println(numPedido);
       atributos.add(numPedido);
       System.out.println("Cliente premium si o no");
       String respuesta=obtenString();
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       cliente = Controlador.recuperarCliente(email);
       System.out.print(cliente);
       if (cliente==null){System.out.println("Cliente no encontrado. Pruebe de nuevo a entrar el pedido\n\n");imprimeAgregarPedido();};
       atributos.add(cliente);
       System.out.println("Introduce el nombre del articulo");
       nombreArticulo = obtenString();
       articulo = Controlador.recuperarArticulo(nombreArticulo);
       if (articulo==null){System.out.println("Articulo no encontrado. Pruebe de nuevo a entrar el pedido\n\n");imprimeAgregarPedido();};       
       atributos.add(articulo);
       System.out.println("Introduce cantidad");
       cantidad = obtenInt();
       atributos.add(cantidad);
       Timestamp date = Timestamp.valueOf(LocalDateTime.now());
       atributos.add(date);
       System.out.println("fecha fijada");
       return atributos;
         */
    }
}
