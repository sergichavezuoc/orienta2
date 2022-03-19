/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 *
 * @author sergichavez
 */
public class Pedido {
private int numPedido;
private Cliente cliente;
private Articulo articulo;
private int cantidad;
private LocalDateTime fecha;


    public Pedido(int numPedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fecha) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
    
       @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Pedido:\n\t" + "NumPedido = " + numPedido + "\n\tcliente = " + cliente.getEmail() + "\n\tarticulo = " + articulo.getDescripcion() + "\n\tFecha = " + fecha.format(formatter) + "\n\tGastos de envio = "+(articulo.getGastos()-(articulo.getGastos()*cliente.descuentoEnv()/100))+" (aplicado descuento "+cliente.descuentoEnv() +"%)\n";
    }
}