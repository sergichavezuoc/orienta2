/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Time;
import java.util.Date;
import model.Articulos;
import model.Clientes;

/**
 *
 * @author sergichavez
 */
public class PedidosView {
     public void printPedidosDetails (int numPedido, Clientes cliente, Articulos articulo, int cantidad, Date fecha, Time hora) {
      System.out.println ( "Pedidos:");
      System.out.println ( "Numero Pedido:" + numPedido);
      System.out.println ( "Cliente:" + cliente.getNombre());
      System.out.println ( "Articulos:" + articulo.getNumArticulo());
      System.out.println ( "Cantidad:" + cantidad);
      System.out.println ( "Fecha:" + fecha);
      System.out.println ( "Hora:" + hora);  
}       
}
