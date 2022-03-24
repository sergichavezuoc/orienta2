
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maria
 */
public class ArticuloDao implements Dao<Articulo> {
        
    Connection conn;
    
    public ArticuloDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Articulo get(long id) {
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM articulo WHERE id = ?")) {
            stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return buildArticulo(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
    @Override
    public List<Articulo> getAll() {
        return null;
    }

    @Override
    public void save(Articulo t) {
    }

    @Override
    
    public void delete(Articulo t) {
    }
    
    private Articulo buildArticulo(ResultSet result) throws SQLException {
        Articulo articulo;
        articulo = new Articulo();
      
        // si llega aquÃ­ es porque no ha petado y devuelto SQLException
        articulo.setNumArticulo(result.getInt("Numero Articulo"));
        articulo.setDescripcion(result.getString("descripción"));
        articulo.setPrecio(result.getInt("precio"));
        articulo.setGastos(result.getInt("Gastos"));
        articulo.setTiempoMinutos(result.getInt("tiempoMinutos"));
        return articulo;
    }
    
}
