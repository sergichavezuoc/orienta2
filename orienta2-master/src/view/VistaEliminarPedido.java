/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static view.VistaStore.obtenInt;

/**
 *
 * @author sergichavez
 */
public class VistaEliminarPedido {
    public static int solicitarPedido(){
      System.out.println("###########################");
      System.out.println("    ELIMINAR PEDIDO     ");
      System.out.println("###########################\n");
      System.out.println("Introduce el un nº entero del pedido a eliminar");
      int pedido = obtenInt();
      return pedido;
   }   
}
