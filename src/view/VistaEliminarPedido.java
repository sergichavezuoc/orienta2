/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import model.ElementNotFound;

/**
 *
 * @author sergichavez
 */
public class VistaEliminarPedido {

    public static void solicitarPedido(Stage primaryStage, MenuBar menuBar) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Formulario de eliminacion de pedidos");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 3, 2, 1);
        Label numero = new Label("Numero de pedido:");
        grid.add(numero, 0, 4);
        TextField numeroTextField = new TextField();
        grid.add(numeroTextField, 1, 4);

        Button btn = new Button("Borrar pedido");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 7);
        VBox vBox = new VBox(menuBar, grid);
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                boolean borrado = false;
                try {
                    borrado = Controlador.eliminarPedido(Long.parseLong(numeroTextField.getText()));
                } catch (ElementNotFound ex) {
                    Logger.getLogger(VistaEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (borrado == true) {
                    GridPane grid = new GridPane();
                    grid.setAlignment(Pos.CENTER);
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
                    Text scenetitle = new Text("Pedido borrado");
                    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
                    grid.add(scenetitle, 0, 0, 2, 1);
                    Label nombre = new Label("El pedido se ha borrado correctamente");
                    grid.add(nombre, 0, 1);
                    VBox vBox = new VBox(menuBar, grid);
                    vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
                    primaryStage.getScene().setRoot(vBox);
                };
                //actiontarget.setText(nifTextField.getText());
            }
        });
    }
}
