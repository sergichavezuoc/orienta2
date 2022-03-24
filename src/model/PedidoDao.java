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
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Articulo;


/**
 *
 * @author maria
 */
public class PedidoDao implements Dao<Pedido> {
    Connection conn;
    
    public ClienteDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Pedido get(long id) {
        
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
    }

    @Override
    public void delete(Pedido t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Articulo buildPedido(ResultSet result) throws SQLException {
        Pedido pedido;
        Articulo articulo;
        pedido = new Pedido();
      
        // si llega aquÃ­ es porque no ha petado y devuelto SQLException
        pedido.setArticulo(result.getObject("articulo",articulo ));
        pedido.setCantidad(result.getInt("cantidad"));
        pedido.setCliente(result.getc("cliente"));
        pedido.setFecha(result.getInt("fecha"));
        pedido.setNumPedido(result.getInt("numero pedido"));
        return pedido;
    }
}
