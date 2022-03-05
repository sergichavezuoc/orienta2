/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author sergichavez
 */
public class ArticulosView {
     public void printArticulosDetails (int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos) {
      System.out.println ( "Articulo:");
      System.out.println ( "Descripcion:" + descripcion);
      System.out.println ( "Precio:" + precio);
      System.out.println ( "Gastos envio:" + gastos);
      System.out.println ( "Tiempo preparacion:" + tiempoMinutos);
      
}   
}
