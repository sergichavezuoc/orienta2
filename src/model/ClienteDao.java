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
import javax.swing.table.DefaultTableModel;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author maria
 */
public class ClienteDao implements Dao<Cliente, String> {
    
    Connection conn;
    DefaultTableModel DT;
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.getTransaction();
    
    public ClienteDao(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public Cliente get(String email) throws ElementNotFound {
        Cliente cliente = null;
        try {
            Query query = session.createQuery("from Cliente WHERE email= :email");
            query.setParameter("email", email);
            cliente = (Cliente)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cliente == null) {
            throw new ElementNotFound("No se ha podido encontrar el articulo introducido");
        }
        return cliente;
    }
    public Cliente getBy(String nif, int numPedido) {
        Query query = session.createQuery("from Cliente WHERE nif= :nif");
            query.setParameter("nif", nif);
                return (Cliente)query.uniqueResult();
    }
   
    
    @Override
    public List<Cliente> getAll() {
    
       Query query = session.createQuery("from Cliente");
        return new ArrayList<Cliente>(query.list());
        
    }
    
    public List<ClientePremium> getAllPremium() {
       Query query = session.createQuery("from Cliente WHERE premium=true");
       return new ArrayList<ClientePremium>(query.list());
    }
    
    public List<ClienteEstandar> getAllEstandar() {
       Query query = session.createQuery("from Cliente WHERE premium=false");
       return new ArrayList<ClienteEstandar>(query.list());    
    }

    @Override
    public boolean save(Cliente t) {
      session.save(t);
        return true;
    }

    @Override
    public boolean delete(String t) {
        return false;
    } 
    
    /*private ClienteEstandar buildClienteE(ResultSet result) throws SQLException {
        
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
    */
}

