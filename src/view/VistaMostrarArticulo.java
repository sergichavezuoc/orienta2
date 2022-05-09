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
import model.Articulo;

/**
 *
 * @author sergichavez
 */
public class VistaMostrarArticulo {

    public static void muestraArticulos(List lista, Stage primaryStage, MenuBar menuBar) {
        //System.out.println("###########################");
        //System.out.println("    LISTADO DE ARTICULOS    ");
        //System.out.println("###########################");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Listado de articulos");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 1, 2, 1);
        Label numero = new Label("Numero articulo");
        numero.setStyle("-fx-font-weight: bold");
        grid.add(numero, 0, 2);
        Label descripcion = new Label("Descripcion");
        descripcion.setStyle("-fx-font-weight: bold");
        grid.add(descripcion, 1, 2);
        Label precio = new Label("Precio");
        precio.setStyle("-fx-font-weight: bold");
        grid.add(precio, 2, 2);
        Label gastos = new Label("Gastos");
        gastos.setStyle("-fx-font-weight: bold");
        grid.add(gastos, 3, 2);
        Label tiempoMinutos = new Label("Tiempo de preparacion");
        tiempoMinutos.setStyle("-fx-font-weight: bold");
        grid.add(tiempoMinutos, 4, 2);
        for (int i = 0; i < lista.size(); i++) {
            Articulo articulo = (Articulo) lista.get(i);
            Label dnumero = new Label(String.valueOf(articulo.getNumArticulo()));
            grid.add(dnumero, 0, i + 3);
            Label ddescripcion = new Label(articulo.getDescripcion());
            grid.add(ddescripcion, 1, i + 3);
            Label dprecio = new Label(String.valueOf(articulo.getPrecio()));
            grid.add(dprecio, 2, i + 3);
            Label dgastos = new Label(String.valueOf(articulo.getGastos()));
            grid.add(dgastos, 3, i + 3);
            Label dtiempoMinutos = new Label(String.valueOf(articulo.getTiempoMinutos()));
            grid.add(dtiempoMinutos, 4, i + 3);
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
