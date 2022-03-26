
package model;

import java.util.List;


public class ListaClientes extends Lista<Cliente>{
   
     public static List obtenClientesP(){
        //Declaramos un objeto de tipo List
        List listaClientes;  
        //no se puede referenciar un metodo no estatico en un contexto estatico
        //habria que declarar static los metodos ....
        listaClientes = BaseDatos.obtenClientesP();
        
        return listaClientes;
    }
     public static List obtenClientesE(){
        //Declaramos un objeto de tipo List
        List listaClientes;  
        //no se puede referenciar un metodo no estatico en un contexto estatico
        //habria que declarar static los metodos ....
        listaClientes = BaseDatos.obtenClientesE();
        
        return listaClientes;
     }
}
