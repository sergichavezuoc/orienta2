/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import static view.VistaStore.obtenBoolean;
import static view.VistaStore.obtenString;

/**
 *
 * @author sergichavez
 */
public class VistaNuevoCliente {
   public static List imprimeAgregarCliente(){
       //String nombre, String domicilio, String nif, String email
       String nombre, domicilio, nif, email, premium;
       List<Object> atributos = new ArrayList<Object>();
       System.out.println("###########################");
       System.out.println(" FORMULARIO NUEVO CLIENTE  ");
       System.out.println("###########################");       
       System.out.println("Introduce el nombre del cliente");
       nombre = obtenString();
       atributos.add(nombre);
       System.out.println("Introduce el domicilio del cliente");
       domicilio = obtenString();
       atributos.add(domicilio);
       System.out.println("Introduce el NIF del cliente");
       nif = obtenString();
       atributos.add(nif);
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       atributos.add(email);
       System.out.println("¿El cliente es premium? Responda si o no");
       premium = obtenString();
       atributos.add(premium);
       return atributos;    
        
   }
       
}
