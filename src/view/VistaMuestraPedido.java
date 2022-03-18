/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;

/**
 *
 * @author sergichavez
 */
public class VistaMuestraPedido {
    //PEDIDOS
      public static void muestraPedidos(List lista){
        System.out.println("Lista de pedidos guardados");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }   
}
