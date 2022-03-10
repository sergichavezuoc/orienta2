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
public class controlador {
   private Articulos modelArticulo;
   private Clientes modelCliente;
   private Pedidos modelPedidos;
   private NuevaArticulosView viewNuevaArticulo;
   private ArticulosView viewArticulo;
   private ClientesView viewCliente;
   private NuevaClientesView viewNuevaClientes;
   private PedidosView viewPedidos;
   private EliminarPedidosView viewEliminarPedido;
   private NuevaPedidosView viewNuevaPedidos;
   public controlador (Pedidos model, NuevaPedidosView view) {
      this.modelPedidos = model;
      this.viewNuevaPedidos = view;
   }
   public controlador (Pedidos model, PedidosView view) {
      this.modelPedidos = model;
      this.viewPedidos = view;
   }
   public controlador (Pedidos model, EliminarPedidosView view) {
      this.modelPedidos = model;
      this.viewEliminarPedido = view;
   }
   public controlador (Clientes model, NuevaClientesView view) {
      this.modelCliente = model;
      this.viewNuevaClientes = view;
   }
   public controlador (Clientes model, ClientesView view) {
      this.modelCliente = model;
      this.viewCliente = view;
   } 
   public controlador (Articulos model, NuevaArticulosView view) {
      this.modelArticulo = model;
      this.viewNuevaArticulo = view;
   }
   public controlador (Articulos model, ArticulosView view) {
      this.modelArticulo = model;
      this.viewArticulo = view;
   }
 public void updateViewPedido () {
     
 } 
  public void updateViewCliente () {
           // view.printStudentDetails (model.getName (), model.getRollNo ());
        viewCliente.printClientesDetails (modelCliente.getNombre(), modelCliente.getDomicilio(), modelCliente.getNif(), modelCliente.getEmail(),modelCliente.tipoCliente(), modelCliente.descuentoEnv(),modelCliente.calcAnual());
}
  
  public void updateViewArticulo(){
      viewArticulo.printArticulosDetails(modelArticulo.getNumArticulo(), modelArticulo.getDescripcion(), modelArticulo.getPrecio(), modelArticulo.getGastos(), modelArticulo.getTiempoMinutos());
  }
}
