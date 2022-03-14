/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author paulamc5
 */

public class ListaPedidos extends Lista<Pedidos>{
    protected String pedidos;
    
    public ListaPedidos(int numPedido, Clientes cliente, Articulos articulo, int cantidad, Date fecha, Time hora){
        super();
        pedidos = String.valueOf(numPedido);
        
    }
}
