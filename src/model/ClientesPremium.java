/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sergichavez
 */
public class ClientesPremium extends Clientes {
     public ClientesPremium(String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email);
    }  
     public float descuentoEnv() { return 20;};
     public String tipoCliente() {return "Premium";};
     public float calcAnual(){ return 30;};
}
