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
/**
 *
 * @author maria
 */
public class ClienteDao implements Dao<Cliente> {
    
    Connection conn;
    
    public ClienteDao(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Cliente get(long id) {
      return null;  
    }
    @Override
    public Cliente get(String email) {
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM cliente WHERE email = ?")) {
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return buildCliente(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getNombre(String email) {
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM cliente WHERE email = ?")) {
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("nombre");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public void save(Cliente t) {
        
    }

    @Override
    public void delete(Cliente t) {
    }
    
    private Cliente buildCliente(ResultSet result) throws SQLException {
        Cliente cliente;
        if (result.getString("premium").equals("si")) {
            cliente = new ClientePremium();
        } else {
            cliente = new ClienteEstandar();
        }
        // si llega aquÃ­ es porque no ha petado y devuelto SQLException
        cliente.setNombre(result.getString("nombre"));
        cliente.setDomicilio(result.getString("domicilio"));
        cliente.setEmail(result.getString("email"));
        return cliente;
    }
    
}
