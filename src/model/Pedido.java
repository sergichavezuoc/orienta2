/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 *
 * @author sergichavez
 */
public class Pedido {
protected Long numPedido;
protected Cliente cliente;
protected Articulo articulo;
protected int cantidad;
protected Timestamp fecha;

    public Pedido(){
        
    }
    public Pedido(Long numPedido, Cliente cliente, Articulo articulo, int cantidad, Timestamp fecha) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        
    }

    public Long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Long numPedido) {
        this.numPedido = numPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    /*
    public Timestamp setFechaSQL(LocalDateTime fecha){
        this.fecha = fecha;
        return fecha == null ? null : Timestamp.valueOf(fecha);      
    }
    */
    
    public boolean equals(Object obj){
        if(obj==null)return false;
        if(!this.getClass().equals(obj.getClass())) return false;
        
        Pedido obj2 = (Pedido)obj;
        if(this.numPedido == obj2.getNumPedido()){
            return true;
        }
        return false;
    }
    public int hashCode(){
        int tmp = 0;
        tmp = (numPedido).hashCode();
        return tmp;
    }
    
    
       @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter isoFecha =DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoHora =DateTimeFormatter.ISO_LOCAL_TIME;

        return "Pedido:\n\t" + "NumPedido = " + numPedido + "\n\tcliente = " + cliente.getNombre() +  "\n\tarticulo = " + articulo.getDescripcion() +"\n\tFecha = "  + "\n\tGastos de envio = "+(articulo.getGastos()-(articulo.getGastos()*cliente.descuentoEnv()/100))+" (aplicado descuento "+cliente.descuentoEnv() + "%)\n";
    }
}
