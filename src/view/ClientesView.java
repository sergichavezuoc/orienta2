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
public class ClientesView {
      public void printClientesDetails (String nombre, String domicilio, String nif, String email, boolean premium) {
      System.out.println ( "Cliente:");
      System.out.println ( "Nombre:" + nombre);
      System.out.println ( "Domicilio:" + domicilio);
      System.out.println ( "NIF:" + nif);
      System.out.println ( "Email:" + email);
      System.out.println ( "Premiun:" + premium);
      
}      
}
