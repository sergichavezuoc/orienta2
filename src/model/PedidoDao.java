/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author maria
 */
public class PedidoDao implements Dao<Pedido, Long> {
    Connection conn;
    
    public PedidoDao(Connection conn) {
        this.conn = conn;
    }
    
    public Pedido get(String id) {
        return null;
    }
    @Override
    public Pedido get(Long id) throws ElementNotFound {
        
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM pedido WHERE id = ?")) {
            stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return buildPedido(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  
    @Override
    public List<Pedido> getAll() throws ElementNotFound {
      ArrayList<Pedido> pedidos = new ArrayList<>();
      
      try{
          PreparedStatement stmt = conn.prepareStatement("SELECT numPedido, nif, numArticulo, cantidad, CONCAT(fecha,hora) AS fechaHora FROM pedido");
          ResultSet result = stmt.executeQuery();
          while(result.next()){
              Pedido buildPedido = buildPedido(result);
              pedidos.add(buildPedido);
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      return pedidos;
    }

    @Override
    public boolean save(Pedido t) {
        LocalDateTime fecha = t.fecha;
        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoHora =DateTimeFormatter.ISO_LOCAL_TIME;
        boolean exito = false;
        
        try (
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO pedido (numPedido, nif, numArticulo, cantidad, fecha, hora) VALUES (?,?,?,?,?,?)")) {
            stmt.setLong(1, t.numPedido);
            stmt.setString(2, t.cliente.getNif());
            stmt.setInt(3, t.articulo.getNumArticulo());
            stmt.setInt(4, t.cantidad);
            stmt.setString(5, fecha.format(isoFecha));
            stmt.setString(6, fecha.format(isoHora));          
            stmt.executeUpdate();
            exito =true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return exito;
    }

    @Override
    public void delete(Long numPedido) throws ElementNotFound {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM pedido WHERE numPedido=?");
            stmt.setLong(1, numPedido);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ElementNotFound("No se ha podido encontrar el pedido a eliminar");
        }
    }
    private Pedido buildPedido(ResultSet result) throws SQLException, ElementNotFound {
        Pedido pedido= new Pedido();
        Articulo articulo;
        Cliente cliente;
        
        articulo = new ArticuloDao(conn).get(result.getLong("numArticulo"));
        pedido.setArticulo(articulo);
        pedido.setCantidad(result.getInt("cantidad"));
        cliente = new ClienteDao(conn).getBy(result.getString("nif"), result.getInt("numArticulo"));
        pedido.setCliente(cliente);   
        String str = result.getString("fechaHora");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
        LocalDateTime LDT = LocalDateTime.parse(str, formatter);
        pedido.setFecha(LDT);
        pedido.setNumPedido(result.getInt("numPedido"));
        return pedido;
        
    }
}
