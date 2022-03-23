/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.ClienteDao;
import java.sql.Connection;
/**
 *
 * @author sergichavez
 */
public abstract class Cliente {
 protected String nombre;
 protected String domicilio;
 protected String nif;
 protected String email;
 protected boolean premium=false;
       
    public Cliente(String nombre, String domicilio, String nif, String email,boolean premium) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Cliente get(String email){
      Cliente clientedevuelto;
      Connection conn = null;
      clientedevuelto = new ClienteDao(conn).get(email);
      return clientedevuelto;
    };
    
 public abstract String tipoCliente();
 
 public abstract float calcAnual();
 
 public abstract float descuentoEnv();
}