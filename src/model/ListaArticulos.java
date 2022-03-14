/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author paulamc5
 */
public class ListaArticulos extends Lista<Articulos>{
    protected String articulos;
    
    public ListaArticulos(int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos){
        super();
        articulos = String.valueOf(numArticulo);
        
    }
}
