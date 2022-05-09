package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import view.*;

public class OnlineStore extends Application {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("").setLevel(Level.OFF);
        Application.launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("onlineStore");

        MenuBar menuBar = VistaMenu.menu(primaryStage);
        Text text = new Text(25, 25, "bienvenido a la aplicacion");
        text.setText("\n\nBienvenido a onlineStore");
        text.setFill(Color.BLACK);
        text.setFont(Font.font(24));
        text.setTextAlignment(TextAlignment.CENTER);
        StackPane root = new StackPane();

        root.getChildren().add(text);

        VBox vBox = new VBox(menuBar, root);
        vBox.setStyle("-fx-base: honeydew;-fx-font-color: black;");
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    //arrancar el menu
    // controlador.mostrarMenuPrincipal();
}
