/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlador.Controlador;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Articulo;
import model.Cliente;
import static view.VistaStore.obtenInt;
import static view.VistaStore.obtenString;

/**
 *
 * @author sergichavez
 */
public class VistaNuevoPedido {
       public static List imprimeAgregarPedido(){
       //int numArticulo, String descripcion, int precio, int gastos, int tiempoMinutos
       int numPedido, cantidad;
       Cliente cliente;
       Articulo articulo;
       Date fecha;
       Time hora;
       String email;
       List<Object> atributos = new ArrayList<Object>();
       
       System.out.println("Introduce el un nº entero correspondiente al codigo del pedido");
       numPedido = obtenInt();
       atributos.add(numPedido);
       System.out.println("Cliente premium si o no");
       String respuesta=obtenString();
       System.out.println("Introduce el email del cliente");
       email = obtenString();
       if (respuesta.equals("si")) {cliente = Controlador.recuperarCliente(email);}
       else {cliente = Controlador.recuperarClienteE(email);};
       if (cliente==null){System.out.println("Cliente no encontrado. Pruebe de nuevo a entrar el pedido\n\n");imprimeAgregarPedido();};
       atributos.add(cliente);
       System.out.println("Introduce el codigo del articulo");
       int codigoArticulo = obtenInt();
       articulo = Controlador.recuperarArticulo(codigoArticulo);
       if (articulo==null){System.out.println("Articulo no encontrado. Pruebe de nuevo a entrar el pedido\n\n");imprimeAgregarPedido();};       
       atributos.add(articulo);
       System.out.println("Introduce cantidad");
       cantidad = obtenInt();
       atributos.add(cantidad);
       LocalDateTime date = LocalDateTime.now();
       atributos.add(date);
       System.out.println("fecha fijada");
       return atributos;    
        
   }    
}
