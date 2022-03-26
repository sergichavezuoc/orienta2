package controlador;


public class OnlineStore {
     
    public static void main(String[] args) throws Exception {
        Controlador controlador = new Controlador();
        // Cargamos "base de datos"
        controlador.cargarDatos();
        //arrancar el menu
        controlador.mostrarMenuPrincipal();
    }
}