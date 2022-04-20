/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Connection;

/**
 *
 * @author sergichavez
 */
public class Articulo implements Serializable{
  protected Long numArticulo;
  protected String descripcion;
  protected int precio;
  protected int gastos;
  protected int tiempoMinutos; 

    public Articulo(){
        
    }
  
    public Articulo(Long numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos) {
        this.numArticulo = numArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastos = gastos;
        this.tiempoMinutos = tiempoMinutos;
    }

    public Long getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(Long numArticulo) {
        this.numArticulo = numArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }

    public int getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(int tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }
   @Override
    public String toString() {
        return "Articulo:\n\t" + "NumArticulo = " + numArticulo + "\n\tdescripcion = " + descripcion + "\n\tprecio = " + precio + "\n\tTiempoMinutos = " + tiempoMinutos + "\n\n";
    }
}
