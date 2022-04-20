/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renatasanchezpaez
 */
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of getNombre method, of class Cliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cliente instance = new ClienteImpl();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Cliente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Cliente instance = new ClienteImpl();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDomicilio method, of class Cliente.
     */
    @Test
    public void testGetDomicilio() {
        System.out.println("getDomicilio");
        Cliente instance = new ClienteImpl();
        String expResult = "";
        String result = instance.getDomicilio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDomicilio method, of class Cliente.
     */
    @Test
    public void testSetDomicilio() {
        System.out.println("setDomicilio");
        String domicilio = "";
        Cliente instance = new ClienteImpl();
        instance.setDomicilio(domicilio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNif method, of class Cliente.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        Cliente instance = new ClienteImpl();
        String expResult = "";
        String result = instance.getNif();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNif method, of class Cliente.
     */
    @Test
    public void testSetNif() {
        System.out.println("setNif");
        String nif = "";
        Cliente instance = new ClienteImpl();
        instance.setNif(nif);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Cliente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Cliente instance = new ClienteImpl();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Cliente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Cliente instance = new ClienteImpl();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPremium method, of class Cliente.
     */
    @Test
    public void testGetPremium() {
        System.out.println("getPremium");
        Cliente instance = new ClienteImpl();
        boolean expResult = false;
        boolean result = instance.getPremium();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPremium method, of class Cliente.
     */
    @Test
    public void testSetPremium() {
        System.out.println("setPremium");
        boolean premium = false;
        Cliente instance = new ClienteImpl();
        instance.setPremium(premium);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tipoCliente method, of class Cliente.
     */
    @Test
    public void testTipoCliente() {
        System.out.println("tipoCliente");
        Cliente instance = new ClienteImpl();
        String expResult = "";
        String result = instance.tipoCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcAnual method, of class Cliente.
     */
    @Test
    public void testCalcAnual() {
        System.out.println("calcAnual");
        Cliente instance = new ClienteImpl();
        float expResult = 0.0F;
        float result = instance.calcAnual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of descuentoEnv method, of class Cliente.
     */
    @Test
    public void testDescuentoEnv() {
        System.out.println("descuentoEnv");
        Cliente instance = new ClienteImpl();
        float expResult = 0.0F;
        float result = instance.descuentoEnv();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ClienteImpl extends Cliente {

        public String tipoCliente() {
            return "";
        }

        public float calcAnual() {
            return 0.0F;
        }

        public float descuentoEnv() {
            return 0.0F;
        }
    }
    
}
