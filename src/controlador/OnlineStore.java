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


    // Update model data controller.setStudentName ( "John");
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
}
