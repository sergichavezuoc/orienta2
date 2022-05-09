package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista<T> {

    public ArrayList<T> devuelveObjetos(ArrayList<T> arrayEnviado) {

        //declaramos un array de tipo generico y lo inicializamos
        ArrayList<T> array = new ArrayList<T>();
        //Se declara el objeto Iterator para recorrer el array enviado
        Iterator<T> iterator = arrayEnviado.iterator();
        //se añaden los objetos al array declarado
        while (iterator.hasNext()) {
            array.add(iterator.next());
        }
        //devuelve el array
        return array;
    }
}
