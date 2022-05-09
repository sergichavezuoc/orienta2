/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author sergichavez
 */
public class VistaNuevoArticulo {

    public static void imprimeAgregarArticulo(Stage primaryStage, MenuBar menuBar) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Formulario de entrada de articulos");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 2, 2, 1);
        Label numero = new Label("Numero de articulo:");
        grid.add(numero, 0, 3);
        TextField numeroTextField = new TextField();
        grid.add(numeroTextField, 1, 3);
        Label descripcion = new Label("Descripcion:");
        grid.add(descripcion, 0, 4);
        TextField descripcionTextField = new TextField();
        grid.add(descripcionTextField, 1, 4);

        Label precio = new Label("Precio:");
        grid.add(precio, 0, 5);
        TextField precioTextField = new TextField();
        grid.add(precioTextField, 1, 5);

        Label gastos = new Label("Gastos:");
        grid.add(gastos, 0, 6);
        TextField gastosTextField = new TextField();
        grid.add(gastosTextField, 1, 6);
        Label tiempoMinutos = new Label("Tiempo de preparacion:");
        grid.add(tiempoMinutos, 0, 7);
        TextField tiempoMinutosTextField = new TextField();
        grid.add(tiempoMinutosTextField, 1, 7);
        Button btn = new Button("Entrar Articulo");
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
                atributos.add(descripcionTextField.getText());
                atributos.add(Integer.parseInt(precioTextField.getText()));
                atributos.add(Integer.parseInt(gastosTextField.getText()));
                atributos.add(Integer.parseInt(tiempoMinutosTextField.getText()));
                boolean exito = Controlador.agregarArticulo(atributos);
                if (exito == true) {
                    GridPane grid = new GridPane();
                    grid.setAlignment(Pos.CENTER);
                    grid.setHgap(10);
                    grid.setVgap(10);
                    Text scenetitle = new Text("Articulo incorporado");
                    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
                    grid.add(scenetitle, 0, 0, 2, 1);
                    Label nombre = new Label("El articulo se ha introducido");
                    grid.add(nombre, 0, 1);
                    VBox vBox = new VBox(menuBar, grid);
                    primaryStage.getScene().setRoot(vBox);
                };
                //actiontarget.setText(nifTextField.getText());
            }
        });
        /*
        int precio, gastos, tiempoMinutos;
       Long numArticulo;
       String descripcion;
       List<Object> atributos = new ArrayList<Object>();
       System.out.println("###########################");
       System.out.println(" FORMULARIO NUEVO ARTICULO ");
       System.out.println("###########################");       
       System.out.println("Introduce el un nº entero correspondiente al codigo del articulo");
       numArticulo = obtenLong();
       atributos.add(numArticulo);
       System.out.println("Introduce una descripcion del articulo");
       descripcion = obtenString();
       atributos.add(descripcion);
       System.out.println("Introduce un nº entero para el precio del articulo");
       precio = obtenInt();
       atributos.add(precio);
       System.out.println("Introduce el un nº entero para los gastos de envio");
       gastos = obtenInt();
       atributos.add(gastos);
       System.out.println("Introduce el un nº entero para la elaboracion del articulo en minutos");
       tiempoMinutos = obtenInt();
       atributos.add(tiempoMinutos);
       return atributos; 
         */

    }

}
