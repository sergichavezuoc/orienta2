/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.ClienteDao;
import java.sql.Connection;
import java.util.Set;
import javax.persistence.Column;
import org.hibernate.annotations.Type;
/**
 *
 * @author sergichavez
 */
public abstract class Cliente {
 protected String nombre;
 protected String domicilio;
 protected String nif;
 protected String email;
 protected boolean premium;
 protected Set <Pedido> pedidos;
     
    public Cliente(){
        
    }
    
    public Cliente(String nombre, String domicilio, String nif, String email,boolean premium) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.premium = premium;
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
    
    public boolean getPremium(){
        return premium;
    }
    
    public void setPremium(boolean premium){
        this.premium = premium;
    }
    public Set getPedidos(){
        return pedidos;
    }
    public void setPedidos(Set pedido){
        this.pedidos= pedidos;
    }
 public abstract String tipoCliente();
 
 public abstract float calcAnual();
 
 public abstract float descuentoEnv();
}