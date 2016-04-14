/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestpointofsalesystem;

import pointofsalesystem.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pointofsalesystem.Item;
import pointofsalesystem.StockCache;
import pointofsalesystem.Transaction;
import static org.junit.Assert.*;

/**
 *
 * @author mileszwicky
 */
public class StockCache2Test {
    
    public StockCache2Test() {
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
     * Test of getInstance method, of class StockCache.
     */
    @Test
    public void testGetInstance() {
	System.out.println("getInstance");
	StockCache expResult = null;
	StockCache result = StockCache.getInstance();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class StockCache.
     */
    @Test
    public void testAddItem() {
	System.out.println("addItem");
	Item myItem = null;
	boolean expResult = false;
	boolean result = StockCache.addItem(myItem);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of printItems method, of class StockCache.
     */
    @Test
    public void testPrintItems() {
	System.out.println("printItems");
	StockCache.printItems();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of emptyCache method, of class StockCache.
     */
    @Test
    public void testEmptyCache() {
	System.out.println("emptyCache");
	StockCache.emptyCache();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class StockCache.
     */
    @Test
    public void testGetItem() {
	System.out.println("getItem");
	int itemID = 0;
	Item expResult = null;
	Item result = StockCache.getItem(itemID);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of saveTransactions method, of class StockCache.
     */
    @Test
    public void testSaveTransactions() {
	System.out.println("saveTransactions");
	ArrayList<Transaction> trans = null;
	boolean expResult = false;
	boolean result = StockCache.saveTransactions(trans);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of loadTransactions method, of class StockCache.
     */
    @Test
    public void testLoadTransactions() {
	System.out.println("loadTransactions");
	ArrayList<Transaction> expResult = null;
	ArrayList<Transaction> result = StockCache.loadTransactions();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
