
package model;

/**
 *
 * @author paulamc5
 */
public class ListaClientes extends Lista<Clientes>{
    protected String clientes;
    
    public ListaClientes(String nombre, String domicilio, String nif, String email){
        super();
        clientes = email;
    }
}
