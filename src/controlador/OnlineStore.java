package controlador;
import java.util.logging.Level;
import java.util.logging.Logger;




public class OnlineStore {
     
    public static void main(String[] args) throws Exception {
        Logger.getLogger("").setLevel(Level.OFF);
        Controlador controlador = new Controlador();
        
        //arrancar el menu
        controlador.mostrarMenuPrincipal();
    }
}