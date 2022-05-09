package model;

import model.Cliente;

/**
 *
 * @author sergichavez
 */
public class ClienteEstandar extends Cliente {

    public ClienteEstandar(String nombre, String domicilio, String nif, String email, boolean premium) {
        super(nombre, domicilio, nif, email, premium);
        //premium =false;
    }

    public ClienteEstandar() {
        super(null, null, null, null, false);
    }

    public float descuentoEnv() {
        return 0;
    }

    ;
     public String tipoCliente() {
        return "Standard";
    }

    ;
     public float calcAnual() {
        return 0;
    }

    ;
       @Override
    public String toString() {
//        return "Cliente :\n\t" + "nombre = " + nombre + "\n\tdomicilio = " + domicilio + "\n\tnif = " + nif + "\n\temail = " + email + "\n\tpremium = " + premium + "\n\tcuota anual = " + calcAnual() + "\n\n";
        return nombre;
    }
}
