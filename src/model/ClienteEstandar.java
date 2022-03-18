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
public class ClienteEstandar extends Cliente {
       public ClienteEstandar(String nombre, String domicilio, String nif, String email, boolean premium) {
        super(nombre, domicilio, nif, email, premium);
        premium =false;
    }   
     public float descuentoEnv() { return 0;};
     public String tipoCliente() {return "Standard";};
     public float calcAnual(){ return 0;};
       @Override
    public String toString() {
        return "Cliente Estandar:\n\t" + "nombre = " + nombre + "\n\tdomicilio = " + domicilio + "\n\tnif = " + nif + "\n\temail = " + email + "\n\tpremium = " + premium + "\n\n";
    }
}
