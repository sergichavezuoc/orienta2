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
import javax.swing.table.DefaultTableModel;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PedidoDao implements Dao<Pedido, Long> {
    Connection conn;
    DefaultTableModel DT;
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.getTransaction();
    
    public PedidoDao(Connection conn) {
        this.conn = conn;
    }
    
    public Pedido get(String id) {
        return null;
    }
    @Override
    public Pedido get(Long id) throws ElementNotFound {
        Pedido pedido = null;
        try {
            Query query = session.createQuery("from Pedido WHERE id= :numPedido");
            query.setParameter("id", numPedido);
            cliente = (Cliente)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pedido == null) {
            throw new ElementNotFound("No se ha podido encontrar el pedido introducido");
        }
        return null;
    }

  
    @Override
    public List<Pedido> getAll() throws ElementNotFound {
        Arraylist <Pedido> pedidos = new ArrayList<>();
        try{
            Query query = session.createQuery("from Pedido");
            List<Pedido> empList = query.list();
            for(Pedido pedido:empList){
                pedidos.add(pedido);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (articulos.size() == 0) {
            throw new ElementNotFound("No se ha podido encontrar ningun pedido");
        }
        return articulos; 
    }   
      
      
    @Override
    public boolean save(Pedido t)  throws ElementFound {
        LocalDateTime fecha = t.fecha;
        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoHora =DateTimeFormatter.ISO_LOCAL_TIME;
        boolean exito = false;
        
        try {
            tx=session.getTransaction();
            tx.begin();    
            Pedido pedido = new Pedido();
            pedido.setLong(t.numPedido);
            pedido.setString(t.cliente.getNif());
            
            pedido.setLong(t.articulo.getNumArticulo());
            pedido.setCantidad(t.cantidad);
            pedido.setString(t.fecha.format(isoFecha));
            pedido.setString(t.hora.format(isoHora));
            session.saveOrUpdate(pedido);
            tx.commit();
            exito =true;
        }catch(RuntimeException e){
            throw e;
        }
        return exito
    }

    @Override
    public boolean delete(Long numPedido) {
        Query query = session.createQuery("FROM cliente where numPedido = :numPedido");
        query.setParameter("numPedido", numPedido);
        Cliente cliente = (Cliente)query.uniqueResult();
      session.delete(cliente.getEmail());
      return true;
    }
    
   /* private Pedido buildPedido(ResultSet result) throws SQLException, ElementNotFound {
        Pedido pedido;
        Articulo articulo;
        Cliente cliente;
        
        pedido.setNumPedido(result.getLong("numPedido"));
        
        int cantidad = result.getInt("cantidad"); 
        cliente = new ClienteDao(conn).getBy(result.getString("nif"), result.getInt("numPedido"));     
        String str = result.getString("fechaHora");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
        LocalDateTime LDT = LocalDateTime.parse(str, formatter);
        int numPedido = result.getInt("numPedido");
        pedido = new Pedido (numPedido, cliente, articulo, cantidad, LDT);
        return pedido;
          
    }
}
