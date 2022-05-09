/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.ElementNotFound;

/**
 *
 * @author sergichavez
 */
public class VistaMenu {
    //MENU PEDIDOS

    public static MenuBar menu(Stage primaryStage) {
        MenuItem menuItem1 = new MenuItem("Nuevo cliente");

        MenuItem menuItem2 = new MenuItem("Listar clientes");
        MenuItem menuItem8 = new MenuItem("Listar clientes Premium");
        MenuItem menuItem9 = new MenuItem("Listar clientes Estandar");
        Menu menu = new Menu("Clientes");
        MenuItem menuItem3 = new MenuItem("Nuevo articulo");
        MenuItem menuItem4 = new MenuItem("Listar articulos");
        Menu menu1 = new Menu("Articulos");
        MenuItem menuItem5 = new MenuItem("Nuevo pedido");
        MenuItem menuItem6 = new MenuItem("Listar pedidos");
        MenuItem menuItem7 = new MenuItem("Borrar pedidos");
        Menu menu2 = new Menu("Pedidos");
        MenuItem menuItem10 = new MenuItem("Salir");
        MenuItem menuItem11 = new MenuItem("Acerca");
        menu.setStyle("-fx-text-fill: black");
        menu1.setStyle("-fx-text-fill: black");
        menu2.setStyle("-fx-text-fill: black");
        menuItem1.setStyle("-fx-text-fill: black");
        menuItem2.setStyle("-fx-text-fill: black");
        menuItem3.setStyle("-fx-text-fill: black");
        menuItem4.setStyle("-fx-text-fill: black");
        menuItem5.setStyle("-fx-text-fill: black");
        menuItem6.setStyle("-fx-text-fill: black");
        menuItem7.setStyle("-fx-text-fill: black");
        menuItem8.setStyle("-fx-text-fill: black");
        menuItem9.setStyle("-fx-text-fill: black");
        menuItem10.setStyle("-fx-text-fill: black");
        menuItem11.setStyle("-fx-text-fill: black");
        Menu menu3 = new Menu("onlineStore");
        menu3.setStyle("-fx-text-fill: black");

        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem8);
        menu.getItems().add(menuItem9);
        menu1.getItems().add(menuItem3);
        menu1.getItems().add(menuItem4);
        menu2.getItems().add(menuItem5);
        menu2.getItems().add(menuItem6);
        menu2.getItems().add(menuItem7);
        menu3.getItems().add(menuItem10);
        menu3.getItems().add(menuItem11);
        MenuBar menuBar = new MenuBar();

        menuItem10.setOnAction(e -> {
            System.exit(0);

        });
        menuItem11.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca");
            alert.setHeaderText("onlineStore Orienta2");
            String s = "onlineStore es el resultado del trabajo realizado por el equipo de Orienta2";
            alert.setContentText(s);
            alert.show();
        }
        );
        menuItem1.setOnAction(e -> {
            view.VistaNuevoCliente.imprimeAgregarCliente(primaryStage, menuBar);

        });
        menuItem2.setOnAction(e -> {
            Controlador.mostrarClientes(primaryStage, menuBar);

        });
        menuItem8.setOnAction(e -> {
            Controlador.mostrarClientesP(primaryStage, menuBar);

        });
        menuItem9.setOnAction(e -> {
            Controlador.mostrarClientesE(primaryStage, menuBar);

        });
        menuItem6.setOnAction(e -> {
            Controlador.mostrarPedidos(primaryStage, menuBar);

        });
        menuItem7.setOnAction(e -> {
            view.VistaEliminarPedido.solicitarPedido(primaryStage, menuBar);

        });
        menuItem5.setOnAction(e -> {

            try {
                view.VistaNuevoPedido.imprimeAgregarPedido(primaryStage, menuBar);
            } catch (ElementNotFound ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        menuItem4.setOnAction(e -> {

            try {
                Controlador.mostrarArticulos(primaryStage, menuBar);
            } catch (SQLException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        menuItem3.setOnAction(e -> {
            view.VistaNuevoArticulo.imprimeAgregarArticulo(primaryStage, menuBar);

        });
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.setStyle("-fx-base: forestgreen;-fx-font-size: 16px;-fx-text-fill: #000;");
        return (menuBar);
    }

}
