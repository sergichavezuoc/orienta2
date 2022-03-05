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
public class Articulos {
  private int numArticulo;
  private String descripcion;
  private int precio;
  private int gastos;
  private int tiempoMinutos; 

    public Articulos(){
        
    }
  
    public Articulos(int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos) {
        this.numArticulo = numArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastos = gastos;
        this.tiempoMinutos = tiempoMinutos;
    }

    public int getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(int numArticulo) {
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
  
}
