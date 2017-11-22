/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaja Raputa, Agnieszka Wojtowicz
 */
public class CellTest {
    
    public CellTest() {
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
     * Test of getState method, of class Cell.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Cell instance = new Cell();
        
        instance.setState(true);
        
        boolean expResult = true;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Cell.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        boolean state = true;
        Cell instance = new Cell();
        
        instance.setState(state);
        
        boolean expResult = true;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextState method, of class Cell.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");
        int numOfNbrs = 0;
        Cell instanceDead = new Cell(); instanceDead.setState(false);
        Cell instanceAlive = new Cell(); instanceAlive.setState(true);
        
        boolean[] expResult  = {false, false, false, true, false, false, false, false, //dead
                                false, false, true, true, false, false, false, false}; //alive

        
        for (int i = 0; i < 8; i++)
        {
            assertEquals(expResult[i], instanceDead.nextState(i));
            assertEquals(expResult[i+8], instanceAlive.nextState(i));
        }
    }
    
}
