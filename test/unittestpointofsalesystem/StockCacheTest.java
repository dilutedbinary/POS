package unittestpointofsalesystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pointofsalesystem.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pointofsalesystem.Item;
import pointofsalesystem.StockCache;
import static org.junit.Assert.*;

/**
 *
 * @author mileszwicky
 */
public class StockCacheTest {

    public StockCacheTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
	StockCache.getInstance();
    }

    @After
    public void tearDown() {
	StockCache.emptyCache();
    }

    /**
     * Test of getInstance method, of class StockCache. Verifies that it is a
     * singleton
     */
    @Test
    public void testGetInstance() {
	System.out.println("getInstance");
	StockCache expResult = StockCache.getInstance();
	assertNotNull(expResult);
	StockCache result = StockCache.getInstance();
	assertSame("is singleton", expResult, result);

    }

    /**
     * Test of addItem method, of class StockCache.
     */
    @Test
    public void testAddItem() {
	System.out.println("addItem");
	Item myItem = new Item(2, "something", 4.5, 4, "Something longer",8);
	boolean result = StockCache.addItem(myItem);
	assertTrue(result);
    }

    /**
     * Test of printItems method, of class StockCache.
     */
    @Test
    public void testPrintItems() {
	System.out.println("printItems");
	PrintStream stdout = System.out;
	String expected = "\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"    CURRENT INVENTORY    \n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"----------------------------\n" +
"Item 1: [Name: something, Description: Something longer, TaxType: 4, Price: $4.5]\n" +
"Item 2: [Name: some, Description: a descript, TaxType: 2, Price: $5.7]\n\n";
	
	
	
	Item item1 = new Item(1, "something", 4.5, 4, "Something longer",7);
	Item item2 = new Item(2, "some", 5.7, 2, "a descript",6);
	StockCache.emptyCache();
	StockCache.addItem(item1);
	StockCache.addItem(item2);
	

	 ByteArrayOutputStream output = new ByteArrayOutputStream();
      System.setOut(new PrintStream(output));

    
 StockCache.printItems();
     assertEquals(output.toString(), expected);

	System.setOut(stdout);

    }

    /**
     * Test of emptyCache method, of class StockCache.
     */
    @Test
    public void testEmptyCache() {
	System.out.println("emptyCache");
	
	
	StockCache.emptyCache();
    }

    /**
     * Test of getItem method, of class StockCache.
     */
    @Test
    public void testGetItem() {
	System.out.println("getItem");
	Item item1 = new Item(1, "something", 4.5, 4, "Something longer",4);
	Item item2 = new Item(2, "some", 5.7, 2, "a descript",5);
	StockCache.emptyCache();
	StockCache.addItem(item1);
	StockCache.addItem(item2);
	StockCache.printItems();
	Item expResult = null;
	
	Item exp1 = StockCache.getItem(1);
	Item exp2 = StockCache.getItem(2);
	Item expnull = StockCache.getItem(9999);
	assertEquals(exp1, item1);
	assertEquals(exp2, item2);
	assertSame(exp1, item1);
	assertSame(exp2, item2);
	
	assertNull(expnull);
	
	assertNotEquals(exp2, item1);

    }

}
