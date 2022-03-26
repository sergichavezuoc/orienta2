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
public class ClienteDao implements Dao<Cliente, String> {
    
    Connection conn;
    
    public ClienteDao(Connection conn) {
        this.conn = conn;
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
    
    public String getByNombre(String email) {
        return get(email).getEmail();
    }
   
    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public void save(Cliente t) {
        try (PreparedStatement stmt = conn
                .prepareStatement("INSERT INTO cliente (nombre,domicilio,nif,email,premium) VALUES (?,?,?,?,?)")) {
            stmt.setString(1, t.nombre);
            stmt.setString(2, t.domicilio);
            stmt.setString(3, t.nif);
            stmt.setString(4, t.email);
            if (t instanceof ClientePremium) {
                stmt.setString(5,"si");
            } else {
                stmt.setString(5,"no");
            }
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
