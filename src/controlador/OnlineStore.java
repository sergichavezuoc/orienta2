package controlador;


public class OnlineStore {
     
    public static void main(String[] args) throws Exception {
        // Cargamos "base de datos"
        Controlador.cargarDatos();
        //arrancar el menu
        Controlador.mostrarMenuPrincipal();
    }
}