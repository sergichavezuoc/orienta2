
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
public class ArticuloDao implements Dao<Articulo, Long> {
        
    Connection conn;
    DefaultTableModel DT;
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.getTransaction();
    
    public ArticuloDao(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public Articulo get(Long id) throws ElementNotFound {
        Articulo articulo =null;
        try {
            Query query = session.createQuery("from Articulo WHERE numArticulo= :id");
            query.setParameter("id", id);
            articulo = (Articulo)query.uniqueResult();
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
            Query query = session.createQuery("from Articulo WHERE descripcion= :nombre");
            query.setParameter("nombre", nombre);
            articulo = (Articulo)query.uniqueResult();
            
            /*
            if(result.next()){
                articulo = buildArticulo(result);
            } else {
                throw new ElementNotFound("No se ha podido encontrar el articulo introducido");
            }*/
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
            Query query = session.createQuery("from Articulo");
            List<Articulo> empList = query.list();
            for(Articulo articulo:empList){
                articulos.add(articulo);
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
        try{
            tx=session.getTransaction();
            tx.begin();    
            Articulo articulo = new Articulo();
            articulo.setDescripcion(t.descripcion);
            articulo.setGastos(t.gastos);
            articulo.setNumArticulo(t.numArticulo);
            articulo.setPrecio(t.precio);
            articulo.setTiempoMinutos(t.tiempoMinutos);
            session.saveOrUpdate(articulo);
            tx.commit();
            exito =true;
        }catch(RuntimeException e){
            throw e;
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
        articulo.setNumArticulo(result.getLong("numArticulo"));
        articulo.setDescripcion(result.getString("descripcion"));
        articulo.setPrecio(result.getInt("precio"));
        articulo.setGastos(result.getInt("gastos"));
        articulo.setTiempoMinutos(result.getInt("tiempoMinutos"));
        return articulo;
    }
    
}
