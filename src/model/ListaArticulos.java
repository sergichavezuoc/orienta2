
package model;


import java.util.List;


public class ListaArticulos extends Lista<Articulo>{
    
    public static List obtenArticulos(){
        //Declaramos un objeto de tipo List
        List listaArticulos;  
        //no se puede referenciar un metodo no estatico en un contexto estatico
        //habria que declarar static los metodos ....
        listaArticulos = BaseDatos.obtenArticulos();
        
        return listaArticulos;
    }
}
