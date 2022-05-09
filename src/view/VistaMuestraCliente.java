/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteEstandar;
import model.ClientePremium;

/**
 *
 * @author sergichavez
 */
public class VistaMuestraCliente {

    public static void muestraClientes(List lista, Stage primaryStage, MenuBar menuBar) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Listado Clientes");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 1, 2, 1);
        Label nombre = new Label("Nombre");
        nombre.setStyle("-fx-font-weight: bold");
        grid.add(nombre, 0, 2);
        Label domicilio = new Label("Domicilio");
        domicilio.setStyle("-fx-font-weight: bold");
        grid.add(domicilio, 1, 2);
        Label nif = new Label("Nif");
        nif.setStyle("-fx-font-weight: bold");
        grid.add(nif, 2, 2);
        Label email = new Label("Email");
        email.setStyle("-fx-font-weight: bold");
        grid.add(email, 3, 2);
        Label premium = new Label("Tipo de cliente");
        premium.setStyle("-fx-font-weight: bold");
        grid.add(premium, 4, 2);
        for (int i = 0; i < lista.size(); i++) {

            Cliente cliente = (Cliente) lista.get(i);
            Label datos = new Label(cliente.getNombre());
            grid.add(datos, 0, i + 3);
            Label ddomicilio = new Label(cliente.getDomicilio());
            grid.add(ddomicilio, 1, i + 3);
            Label dnif = new Label(cliente.getNif());
            grid.add(dnif, 2, i + 3);
            Label dmail = new Label(cliente.getEmail());
            grid.add(dmail, 3, i + 3);
            Label dpremium = new Label(cliente.tipoCliente());
            grid.add(dpremium, 4, i + 3);
//System.out.println(lista.get(i));
        }
        ScrollPane sp = new ScrollPane();      
        sp.setContent(grid);
        VBox vBox = new VBox(menuBar, sp);
        sp.setPadding(new Insets(20, 10, 20, 80));
        sp.setStyle("-fx-background-color:transparent;");
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
    }

    //CLIENTES
    public static void muestraClientesP(List lista, Stage primaryStage, MenuBar menuBar) {
        //System.out.println("###########################");
        //System.out.println(" LISTADO CLIENTES PREMIUM  ");
        //System.out.println("###########################\n");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Listado Clientes Premium");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 1, 2, 1);
        Label nombre = new Label("Nombre");
        nombre.setStyle("-fx-font-weight: bold");

        grid.add(nombre, 0, 2);
        Label domicilio = new Label("Domicilio");
        domicilio.setStyle("-fx-font-weight: bold");
        grid.add(domicilio, 1, 2);
        Label nif = new Label("Nif");
        nif.setStyle("-fx-font-weight: bold");
        grid.add(nif, 2, 2);
        Label email = new Label("Email");
        email.setStyle("-fx-font-weight: bold");
        grid.add(email, 3, 2);
        Label premium = new Label("Tipo de cliente");
        premium.setStyle("-fx-font-weight: bold");
        grid.add(premium, 4, 2);
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println(lista.get(i));
            ClientePremium cliente = (ClientePremium) lista.get(i);
            Label datos = new Label(cliente.getNombre());
            grid.add(datos, 0, i + 3);
            Label ddomicilio = new Label(cliente.getDomicilio());
            grid.add(ddomicilio, 1, i + 3);
            Label dnif = new Label(cliente.getNif());
            grid.add(dnif, 2, i + 3);
            Label dmail = new Label(cliente.getEmail());
            grid.add(dmail, 3, i + 3);
            Label dpremium = new Label(cliente.tipoCliente());
            grid.add(dpremium, 4, i + 3);
        }
                ScrollPane sp = new ScrollPane();      
        sp.setContent(grid);
        VBox vBox = new VBox(menuBar, sp);
        sp.setPadding(new Insets(20, 10, 20, 80));
        sp.setStyle("-fx-background-color:transparent;");
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
    }

    public static void muestraClientesE(List lista, Stage primaryStage, MenuBar menuBar) {
        //System.out.println("LISTADO DE CLIENTES ESTÁNDAR");
        //System.out.println("*****************************");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Listado Clientes Estandar");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 1, 2, 1);
        Label nombre = new Label("Nombre");
        nombre.setStyle("-fx-font-weight: bold");
        grid.add(nombre, 0, 2);
        Label domicilio = new Label("Domicilio");
        domicilio.setStyle("-fx-font-weight: bold");
        grid.add(domicilio, 1, 2);
        Label nif = new Label("Nif");
        nif.setStyle("-fx-font-weight: bold");
        grid.add(nif, 2, 2);
        Label email = new Label("Email");
        email.setStyle("-fx-font-weight: bold");
        grid.add(email, 3, 2);
        Label premium = new Label("Tipo de cliente");
        premium.setStyle("-fx-font-weight: bold");
        grid.add(premium, 4, 2);
        for (int i = 0; i < lista.size(); i++) {
            ClienteEstandar cliente = (ClienteEstandar) lista.get(i);
            Label datos = new Label(cliente.getNombre());
            grid.add(datos, 0, i + 3);
            Label ddomicilio = new Label(cliente.getDomicilio());
            grid.add(ddomicilio, 1, i + 3);
            Label dnif = new Label(cliente.getNif());
            grid.add(dnif, 2, i + 3);
            Label dmail = new Label(cliente.getEmail());
            grid.add(dmail, 3, i + 3);
            Label dpremium = new Label(cliente.tipoCliente());
            grid.add(dpremium, 4, i + 3);
            //System.out.println(lista.get(i));
        }

        ScrollPane sp = new ScrollPane();      
        sp.setContent(grid);
        VBox vBox = new VBox(menuBar, sp);
        sp.setPadding(new Insets(20, 10, 20, 80));
        sp.setStyle("-fx-background-color:transparent;");
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
    }

}
