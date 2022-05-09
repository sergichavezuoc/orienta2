/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import controlador.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sergichavez
 */
public class VistaNuevoCliente {

    public static void imprimeAgregarCliente(Stage primaryStage, MenuBar menuBar) {
        //String nombre, String domicilio, String nif, String email
        //String nombre, domicilio, nif, email;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
        Text scenetitle = new Text("Formulario de entrada de clientes");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
        grid.add(scenetitle, 0, 2, 2, 1);
        Label nombre = new Label("Nombre:");
        grid.add(nombre, 0, 3);
        TextField nombreTextField = new TextField();
        grid.add(nombreTextField, 1, 3);
        Label domicilio = new Label("Domicilio:");
        grid.add(domicilio, 0, 4);
        TextField domicilioTextField = new TextField();
        grid.add(domicilioTextField, 1, 4);

        Label nif = new Label("Nif:");
        grid.add(nif, 0, 5);
        TextField nifTextField = new TextField();
        grid.add(nifTextField, 1, 5);

        Label email = new Label("Email:");
        grid.add(email, 0, 6);
        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 6);
        Label premium = new Label("Premium:");
        grid.add(premium, 0, 7);
        ComboBox premiumComboBox = new ComboBox();
        premiumComboBox.getItems().addAll(
                "si",
                "no"
        );
        grid.add(premiumComboBox, 1, 7);
        Button btn = new Button("Entrar Cliente");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 9);
        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 11);
        VBox vBox = new VBox(menuBar, grid);
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        primaryStage.getScene().setRoot(vBox);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               if (nombreTextField.getText().equals("")){
                    actiontarget.setText("Ha de introducir el Nombre");
                    return;
                }
               if (nifTextField.getText().equals("")){
                    actiontarget.setText("Ha de introducir el NIF");
                    return;
                }
                if (emailTextField.getText().equals("")){
                    actiontarget.setText("Ha de introducir el Email");
                    return;
                }
                List<Object> atributos = new ArrayList<Object>();
                boolean premium = true;
                if (premiumComboBox.getValue().equals("no")) {
                    premium = false;
                };
                atributos.add(nombreTextField.getText());
                atributos.add(domicilioTextField.getText());
                atributos.add(nifTextField.getText());
                atributos.add(emailTextField.getText());
                atributos.add(premium);
                boolean exito = Controlador.agregarCliente(atributos);
                if (exito == true) {
                    GridPane grid = new GridPane();
                    grid.setAlignment(Pos.CENTER);
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setStyle("-fx-font-size: 16px;-fx-text-fill: #000;");
                    Text scenetitle = new Text("Cliente incorporado");
                    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
                    grid.add(scenetitle, 0, 0, 2, 1);
                    Label nombre = new Label("El cliente se ha introducido");
                    grid.add(nombre, 0, 1);
                    VBox vBox = new VBox(menuBar, grid);
                    vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
                    primaryStage.getScene().setRoot(vBox);
                };

            }
        });

        /*    
       boolean premium;
       List<Object> atributos = new ArrayList<Object>();
       System.out.println("###########################");
       System.out.println(" FORMULARIO NUEVO CLIENTE  ");
       System.out.println("###########################");       
       System.out.println("Introduce el nombre del cliente");
       nombre = obtenString();
       atributos.add(nombre);
       System.out.println("Introduce el domicilio del cliente");
       domicilio = obtenString();
       atributos.add(domicilio);
       System.out.println("Introduce el NIF del cliente");
       nif = obtenString();
       atributos.add(nif);
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       atributos.add(email);
       System.out.println("¿El cliente es premium? Responda si o no");
       premium = obtenBoolean();
       atributos.add(premium);
       return atributos;  
         */
    }

}
