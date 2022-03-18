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
public class VistaMostrarArticulo {
public static void muestraArticulos(List lista){
           System.out.println("###########################");
           System.out.println("    LISTADO DE ARTICULOS    ");
           System.out.println("###########################");

        for (int i = 0; i < lista.size(); i++) {           
            System.out.println(lista.get(i));
        }
   }    
}
