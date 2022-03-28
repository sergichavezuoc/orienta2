/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Cliente;

/**
 *
 * @author sergichavez
 */
public class ClientePremium extends Cliente {
     public ClientePremium(String nombre, String domicilio, String nif, String email, boolean premium) {
        super(nombre, domicilio, nif, email, premium);
       // premium = true;
    }  
     
     public ClientePremium() {
        super(null, null, null, null, true);
    }
     public float descuentoEnv() { return 20;};
     public String tipoCliente() {return "Premium";};
     public float calcAnual(){ return 30;};  
     public String toString() {
        premium=true;
        return "Cliente :\n\t" + "nombre = " + nombre + "\n\tdomicilio = " + domicilio + "\n\tnif = " + nif + "\n\temail = " + email + "\n\tpremium = " + premium + "\n\tcuota anual = " + calcAnual() + "\n\n";
    }
}
