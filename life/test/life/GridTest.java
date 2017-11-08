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
public class GridTest {
    
    public GridTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchCell method, of class Grid.
     */
    @Test
    public void testSwitchCell() {
        System.out.println("switchCell");
        int x = 0;
        int y = 0;
        Grid instance = new Grid();
        instance.switchCell(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextState method, of class Grid.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");
        Grid instance = new Grid();
        instance.nextState();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrid method, of class Grid.
     */
    @Test
    public void testGetGrid() {
        System.out.println("getGrid");
        Grid instance = new Grid();
        String expResult = "";
        String result = instance.getGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
