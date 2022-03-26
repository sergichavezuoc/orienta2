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
 * @author sergichavez
 */
public class ClientePremiumTest {
    
    public ClientePremiumTest() {
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
     * Test of descuentoEnv method, of class ClientePremium.
     */
    @Test
    public void testDescuentoEnv() {
        System.out.println("descuentoEnv");
        ClientePremium instance = new ClientePremium("Cliente Premium Test","calle rosa","email@email.com","22222222",true);
        float expResult = 20.0F;
        float result = instance.descuentoEnv();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of tipoCliente method, of class ClientePremium.
     */
    @Test
    public void testTipoCliente() {
        System.out.println("tipoCliente");
        ClientePremium instance = new ClientePremium("Cliente Premium Test","calle rosa","email@email.com","22222222",true);
        String expResult = "Premium";
        String result = instance.tipoCliente();
        assertEquals(expResult, result);

    }

    /**
     * Test of calcAnual method, of class ClientePremium.
     */
    @Test
    public void testCalcAnual() {
        System.out.println("calcAnual");
        ClientePremium instance = new ClientePremium("Cliente Premium Test","calle rosa","email@email.com","22222222",true);
        float expResult = 30.0F;
        float result = instance.calcAnual();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of toString method, of class ClientePremium.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ClientePremium instance = new ClientePremium("Cliente Premium Test","calle rosa","email@email.com","22222222",true);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
