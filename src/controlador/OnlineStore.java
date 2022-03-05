/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import view.*;
import model.*;
/**
 *
 * @author sergichavez
 */
public class OnlineStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    Clientes model = retriveClienteFromDatabase();
    ClientesView view = new ClientesView();
    controlador controller = new controlador(model, view);
    
    if (model instanceof Clientes){
          controller.updateViewCliente ();  
    }
    
    Articulos modelArticulo = retriveArticulosFromDatabase();
    ArticulosView viewArticulo = new ArticulosView();
    controlador controllerArticulo = new controlador(modelArticulo, viewArticulo);
    
    if (modelArticulo instanceof Articulos){
        controllerArticulo.updateViewArticulo();
    }
    
    
    //"supuesta" carga de datos en base de datos
}
 private static Clientes retriveClienteFromDatabase() {
      Clientes cliente = new Clientes ();
      cliente.setNombre ( "Robert");
      cliente.setDomicilio ( "Calle Serrano");
      cliente.setNif ( "222233332X");
      cliente.setEmail ( "juaito@uoc.edu");
      cliente.setPremium(true);
      return cliente;
   }  

private static Articulos retriveArticulosFromDatabase(){
    Articulos articulo = new Articulos();
    articulo.setNumArticulo(01);
    articulo.setDescripcion("Dibujo matematico loco");
    articulo.setPrecio(100000000);
    articulo.setGastos(3);
    articulo.setTiempoMinutos(30);
    return articulo;
} 
}
