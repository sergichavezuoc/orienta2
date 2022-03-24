package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM cliente WHERE id = ?")) {
            stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return buildCliente(result);
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
