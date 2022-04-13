
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author maria
 */
public class ArticuloDao implements Dao<Articulo, Long> {
        
    Connection conn;
    DefaultTableModel DT;
    
    public ArticuloDao(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public Articulo get(Long id) throws ElementNotFound {
        Articulo articulo =null;
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM articulo WHERE numArticulo = ?")) {
            stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                articulo = buildArticulo(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (articulo == null) {
            throw new ElementNotFound("No se ha podido encontrar el articulo introducido");
        }
        return articulo;
    }
    public Articulo getArticulo(String nombre) throws ElementNotFound {
         Articulo articulo=null;
        try{
            PreparedStatement stmt =conn.prepareStatement("SELECT * FROM articulo WHERE descripcion = ?");
            stmt.setString(1, nombre);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                articulo = buildArticulo(result);
            } else {
                throw new ElementNotFound("No se ha podido encontrar el articulo introducido");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (articulo == null) {
            throw new ElementNotFound("No se ha podido encontrar el articulo introducido");
        }
        return articulo;
    }
   
    @Override
    public List<Articulo> getAll() throws ElementNotFound {
        ArrayList <Articulo> articulos = new ArrayList<>();
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM articulo");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Articulo buildArticulo = buildArticulo(result);                
                articulos.add(buildArticulo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (articulos.size() == 0) {
            throw new ElementNotFound("No se ha podido encontrar ningun articulo");
        }
        return articulos;
    }

    @Override
    public boolean save(Articulo t) throws ElementFound {
        boolean exito = false;
                try (PreparedStatement stmt = conn
                .prepareStatement("INSERT INTO articulo (numArticulo, descripcion, precio, gastos, tiempoMinutos) VALUES (?,?,?,?,?)")) {
            stmt.setInt(1, t.numArticulo);
            stmt.setString(2, t.descripcion);
            stmt.setInt(3, t.precio);
            stmt.setInt(4, t.gastos);
            stmt.setInt(5, t.tiempoMinutos);
            int afectadas = stmt.executeUpdate();
            if(afectadas ==0){
                exito=false;
            }else{
                exito =true;
            }
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public boolean delete(Long t) {
        return false;
    }
    
    private Articulo buildArticulo(ResultSet result) throws SQLException {
        Articulo articulo;
        articulo = new Articulo();
      
        // si llega aquÃ­ es porque no ha petado y devuelto SQLException
        articulo.setNumArticulo(result.getInt("numArticulo"));
        articulo.setDescripcion(result.getString("descripcion"));
        articulo.setPrecio(result.getInt("precio"));
        articulo.setGastos(result.getInt("gastos"));
        articulo.setTiempoMinutos(result.getInt("tiempoMinutos"));
        return articulo;
    }
    
}
