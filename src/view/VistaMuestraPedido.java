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
import model.Pedido;

/**
 *
 * @author sergichavez
 */
public class VistaMuestraPedido {

    //PEDIDOS
    public static void muestraPedidos(List lista, Stage primaryStage, MenuBar menuBar) {
        //System.out.println("###########################");
        //System.out.println("    LISTADO DE PEDIDOS    ");
        //System.out.println("###########################\n");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Listado Pedidos");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 1, 2, 1);
        Label numero = new Label("Numero de pedido");
        numero.setStyle("-fx-font-weight: bold");
        grid.add(numero, 0, 2);
        Label cliente = new Label("Cliente");
        cliente.setStyle("-fx-font-weight: bold");
        grid.add(cliente, 1, 2);
        Label articulo = new Label("Articulo");
        articulo.setStyle("-fx-font-weight: bold");
        grid.add(articulo, 2, 2);
        Label cantidad = new Label("Cantidad");
        cantidad.setStyle("-fx-font-weight: bold");
        grid.add(cantidad, 3, 2);
        Label premium = new Label("Fecha");
        premium.setStyle("-fx-font-weight: bold");
        grid.add(premium, 4, 2);
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println(lista.get(i));
            Pedido pedido = (Pedido) lista.get(i);
            Label dnumero = new Label(String.valueOf(pedido.getNumPedido()));
            grid.add(dnumero, 0, i + 3);
            Label dcliente = new Label(pedido.cliente.getEmail());
            grid.add(dcliente, 1, i + 3);
            Label darticulo = new Label(pedido.articulo.getDescripcion());
            grid.add(darticulo, 2, i + 3);
            Label dcantidad = new Label(String.valueOf(pedido.getCantidad()));
            grid.add(dcantidad, 3, i + 3);
            Label dfecha = new Label(String.valueOf(pedido.getFecha()));
            grid.add(dfecha, 4, i + 3);
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
