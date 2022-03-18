
package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListaPedidos  extends Lista<Pedido>{

    public static List obtenPedidos(){
        //Declaramos un objeto de tipo List
        List listaPedidos;  
        //no se puede referenciar un metodo no estatico en un contexto estatico
        //habria que declarar static los metodos ....
        listaPedidos = BaseDatos.obtenPedidos();
        
        return listaPedidos;
    }
    
}