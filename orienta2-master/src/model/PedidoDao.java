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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ClienteDao;
import model.Articulo;
import model.ArticuloDao;


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
    public Pedido get(Long id) {
        
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
    public List<Pedido> getAll() {
      return null;
    }

    @Override
    public void save(Pedido t) {
        try (PreparedStatement stmt = conn
                .prepareStatement("INSERT INTO pedido (numPedido,cliente,articulo,cantidad,fecha) VALUES (?,?,?,?,?)")) {
            stmt.setLong(1, t.numPedido);
            stmt.setString(2, t.cliente.email);
            stmt.setInt(3, t.articulo.getNumArticulo());
            stmt.setInt(4, t.cantidad);
            //TODO convertir fecha de pedido en Date para pasar a SQL date
            java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf(t.fecha);
            stmt.setObject(5, sqlDate);
            stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pedido t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Pedido buildPedido(ResultSet result) throws SQLException {
        Pedido pedido;
        Articulo articulo;
        Cliente cliente;
        pedido = new Pedido();
      
        // si llega aquÃ­ es porque no ha petado y devuelto SQLException
        articulo=new ArticuloDao(conn).get(result.getLong("articulo"));
        pedido.setArticulo(articulo);
        pedido.setCantidad(result.getInt("cantidad"));
        cliente=new ClienteDao(conn).get(result.getString("cliente"));
        pedido.setCliente(cliente);
        // TODO recuperar fecha y convertirla en LocalDateTime
        pedido.setFecha(LocalDateTime.now());
        pedido.setNumPedido(result.getInt("numPedido"));
        return pedido;
    }
}
