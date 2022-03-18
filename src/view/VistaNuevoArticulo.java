/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import static view.VistaStore.obtenInt;
import static view.VistaStore.obtenString;

/**
 *
 * @author sergichavez
 */
public class VistaNuevoArticulo {
   public static List imprimeAgregarArticulo(){
       //int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos
       int numArticulo, precio, gastos, tiempoMinutos;
       String descripcion;
       List<Object> atributos = new ArrayList<Object>();
       
       System.out.println("Introduce el un nº entero correspondiente al codigo del articulo");
       numArticulo = obtenInt();
       atributos.add(numArticulo);
       System.out.println("Introduce una descripcion del articulo");
       descripcion = obtenString();
       atributos.add(descripcion);
       System.out.println("Introduce un nº entero para el precio del articulo");
       precio = obtenInt();
       atributos.add(precio);
       System.out.println("Introduce el un nº entero para los gastos de envio");
       gastos = obtenInt();
       atributos.add(gastos);
       System.out.println("Introduce el un nº entero para la elaboracion del articulo en minutos");
       tiempoMinutos = obtenInt();
       atributos.add(tiempoMinutos);
       return atributos;    
        
   }
   
}
