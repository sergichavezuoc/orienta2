package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Cliente cliente = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente WHERE email = ?")){
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                cliente = FactoryCliente.getCliente(result.getInt("premium"),result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }
    public Cliente getBy(String nif, int numPedido) {
        Cliente cliente = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT nombre, domicilio, cliente.nif, email, premium "
                + "FROM cliente INNER JOIN pedido ON cliente.nif = pedido.nif WHERE pedido.nif= ? AND numPedido=?;")){
            stmt.setString(1, nif);
            stmt.setInt(2, numPedido);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                cliente = FactoryCliente.getCliente(result.getInt("premium"),result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }
   
    
    @Override
    public List<Cliente> getAll() {
        ArrayList <Cliente> clientes = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Cliente cliente = FactoryCliente.getCliente(result.getInt("premium"),result);
                clientes.add(cliente);
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientes;
    }
    
    public List<ClientePremium> getAllPremium() {
        ArrayList <ClientePremium> clientesP = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente WHERE premium=true");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                ClientePremium buildClienteP = buildClienteP(result);
                clientesP.add(buildClienteP);
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientesP;
    }
    
    public List<ClienteEstandar> getAllEstandar() {
        ArrayList <ClienteEstandar> clientesE = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente WHERE premium=false");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                ClienteEstandar buildClienteE = buildClienteE(result);
                clientesE.add(buildClienteE);
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientesE;
    }

    @Override
    public boolean save(Cliente t) {
        boolean exito = false;
        try (PreparedStatement stmt = conn
                .prepareStatement("INSERT INTO cliente (nombre,domicilio,nif,email,premium) VALUES (?,?,?,?,?)")) {
            stmt.setString(1, t.nombre);
            stmt.setString(2, t.domicilio);
            stmt.setString(3, t.nif);
            stmt.setString(4, t.email);
            stmt.setBoolean(5, t.premium); 
            stmt.executeUpdate();
            exito =true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public boolean delete(String t) {
        return false;
    } 
    
    private ClienteEstandar buildClienteE(ResultSet result) throws SQLException {
        
        ClienteEstandar clienteE = new ClienteEstandar();
        clienteE.setNombre(result.getString("nombre"));
        clienteE.setDomicilio(result.getString("domicilio"));
        clienteE.setNif(result.getString("nif"));
        clienteE.setEmail(result.getString("email"));
        clienteE.setPremium(result.getBoolean("premium"));
        
        return clienteE;
    }
    private ClientePremium buildClienteP(ResultSet result) throws SQLException {
        
        ClientePremium clienteP = new ClientePremium();
        clienteP.setNombre(result.getString("nombre"));
        clienteP.setDomicilio(result.getString("domicilio"));
        clienteP.setNif(result.getString("nif"));
        clienteP.setEmail(result.getString("email"));
        clienteP.setPremium(result.getBoolean("premium"));
        
        return clienteP;
    }
    
}

