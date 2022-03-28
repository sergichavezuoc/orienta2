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
public class VistaMuestraCliente {
    public static void muestraClientes(List lista){
        System.out.println("###########################");
        System.out.println("LISTADO DE CLIENTES");
        System.out.println("###########################");
        for (int i = 0; i < lista.size(); i++) {   
            System.out.println(lista.get(i));
        }
    }
    //CLIENTES
   public static void muestraClientesP(List lista){
           System.out.println("###########################");
           System.out.println(" LISTADO CLIENTES PREMIUM  ");
           System.out.println("###########################\n");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }
   public static void muestraClientesE(List lista){
        System.out.println("LISTADO DE CLIENTES ESTÁNDAR");
        System.out.println("*****************************");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }
    
}
