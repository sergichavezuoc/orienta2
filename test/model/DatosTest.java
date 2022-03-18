/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergichavez
 */
public class DatosTest {
    
    public DatosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  



    /**
     * Test of ListarArticulos method, of class Datos.
     */
    @Test
    public void testListarArticulos() {
        System.out.println("ListarArticulos");
        List expResult = BaseDatos.obtenArticulos();
        List result = Datos.ListarArticulos();
        assertEquals(expResult, result);

    }

    /**
     * Test of ListarPedidos method, of class Datos.
     */
    @Test
    public void testListarPedidos() {
        System.out.println("ListarPedidos");
        List expResult = BaseDatos.obtenPedidos();
        List result = Datos.ListarPedidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of ListarClientesP method, of class Datos.
     */
    @Test
    public void testListarClientesP() {
        System.out.println("ListarClientesP");
        List expResult = BaseDatos.obtenClientesP();
        List result = Datos.ListarClientesP();
        assertEquals(expResult, result);

    }

    /**
     * Test of ListarClientesE method, of class Datos.
     */
    @Test
    public void testListarClientesE() {
        System.out.println("ListarClientesE");
        List expResult = BaseDatos.obtenClientesE();
        List result = Datos.ListarClientesE();
        assertEquals(expResult, result);
    }



    /**
     * Test of recuperarClientePremium method, of class Datos.
     */
    @Test
    public void testRecuperarClientePremium() {
        System.out.println("recuperarClientePremium");
        String email = "";
        ClientePremium expResult = null;
        ClientePremium result = Datos.recuperarClientePremium(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of recuperarClienteEstandar method, of class Datos.
     */
    @Test
    public void testRecuperarClienteEstandar() {
        System.out.println("recuperarClienteEstandar");
        String email = "";
        ClienteEstandar expResult = null;
        ClienteEstandar result = Datos.recuperarClienteEstandar(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of recuperarArticulo method, of class Datos.
     */
    @Test
    public void testRecuperarArticulo() {
        System.out.println("recuperarArticulo");
        int codigoArticulo = 0;
        Articulo expResult = null;
        Articulo result = Datos.recuperarArticulo(codigoArticulo);
        assertEquals(expResult, result);
    }
    
}
