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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import net.sf.ehcache.hibernate.HibernateUtil;
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
            Query query = session.createQuery("from Pedido WHERE numPedido= :id");
            query.setParameter("id", id);
            pedido = (Pedido) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pedido == null) {
            throw new ElementNotFound("No se ha podido encontrar el pedido introducido");
        }
        return pedido;
    }

    @Override
    public List<Pedido> getAll() throws ElementNotFound {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            Query query = session.createQuery("from Pedido");
            List<Pedido> empList = query.list();
            for (Pedido pedido : empList) {
                pedidos.add(pedido);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pedidos.size() == 0) {
            throw new ElementNotFound("No se ha podido encontrar ningun articulo");
        }
        return pedidos;
    }

    @Override
    public boolean save(Pedido t) {
        boolean exito = false;
        System.out.println(t.fecha);
        System.out.println(t.numPedido);
        try {
            tx = session.getTransaction();
            tx.begin();
            Pedido pedido = new Pedido();
            pedido.setNumPedido(t.numPedido);
            pedido.setArticulo(t.articulo);
            pedido.setCliente(t.cliente);
            pedido.setFecha(t.fecha);
            pedido.setCantidad(t.cantidad);
            session.save(pedido);
            System.out.println("inicio");
            tx.commit();
            exito = true;
            System.out.println("medio");
        } catch (RuntimeException e) {
            throw e;
        }
        System.out.println("final");
        return exito;
    }

    @Override
    public boolean delete(Long numPedido) throws ElementNotFound {
        boolean exito = false;
        Pedido pedido = get(numPedido);

        LocalDateTime tmpPedido = pedido.getFecha().toLocalDateTime();
        LocalDateTime tmpNow = Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime();
        Long diff = ChronoUnit.MINUTES.between(tmpNow, tmpPedido);
        System.out.println(diff);
        Articulo articulo = pedido.getArticulo();
        int tmp = articulo.getTiempoMinutos();
        Long tmptoLong = 0l;
        tmptoLong = tmptoLong.valueOf(tmp);
        System.out.println(tmptoLong);
        System.out.println((-diff));
        if (tmptoLong > (-diff)) {
            System.out.println(numPedido);
            tx = session.getTransaction();
            tx.begin();
            session.delete(pedido);
            tx.commit();
            session.close();
            //Query query =session.createQuery("Delete FROM Pedido WHERE numPedido = :numPedido").setParameter("numPedido", numPedido);
            //int result =query.executeUpdate(); 
            //if(result >0){
            exito = true;
            //}else{
            //  exito =false;
            //}
        }

        return exito;
    }

}
