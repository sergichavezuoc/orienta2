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
protected int numPedido;
protected Cliente cliente;
protected Articulo articulo;
protected int cantidad;
protected LocalDateTime fecha;

    public Pedido(){
        
    }
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
        this.fecha = LocalDateTime.now();
    }

    
    
       @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter isoFecha =DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoHora =DateTimeFormatter.ISO_LOCAL_TIME;

        return "Pedido:\n\t" + "NumPedido = " + numPedido + "\n\tcliente = " + cliente.getNombre() +  "\n\tarticulo = " + articulo.getDescripcion() +"\n\tFecha = " + fecha.format(isoFecha) + fecha.format(isoHora) + "\n\tGastos de envio = "+(articulo.getGastos()-(articulo.getGastos()*cliente.descuentoEnv()/100))+" (aplicado descuento "+cliente.descuentoEnv() + "%)\n";
    }
}
/*

+ "\n\tarticulo = " + articulo.getDescripcion() + "\n\tFecha = " + fecha.format(isoFecha) + fecha.format(isoHora) + "\n\tGastos de envio = "+(articulo.getGastos()-(articulo.getGastos()*cliente.descuentoEnv()/100))+" (aplicado descuento "+cliente.descuentoEnv() + "%)\n";

 articulo = new ArticuloDao(conn).get(result.getLong("numArticulo"));
        pedido.setArticulo(articulo);
        pedido.setCantidad(result.getInt("cantidad"));
        cliente = new ClienteDao(conn).get(result.getString("nif"));
        pedido.setCliente(cliente);   
        String str = result.getString("fechaHora");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
        LocalDateTime LDT = LocalDateTime.parse(str, formatter);
        pedido.setFecha(LDT);
        System.out.println(LDT);
        pedido.setNumPedido(result.getInt("numPedido"));
        return pedido;
*/