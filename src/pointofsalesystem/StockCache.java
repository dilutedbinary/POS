package pointofsalesystem;

/**
 * @author Miles Zwicky mmz216@lehigh.edu
 * @version .1
 * @since 3-2-2016
 */
import java.util.ArrayList;
import java.io.*;

/**
 * A local version of the inventory list in order to reduce number of calls to
 * the database.
 *
 * Follows the singleton design pattern
 */
public class StockCache {

    /**
     * instance of the StochCache, used for singleton design method.
     */
    private static StockCache instance;
    /**
     * Stock list of items, which in turn have item description and
     */
    private ArrayList<Item> stock = new ArrayList<Item>();

    /**
     * Creates an Item object
     * <p>
     *
     * @param connection -- connection to populate cache
     */
    private StockCache() {
    }

    public static StockCache getInstance() {
	if (instance == null) {
	    instance = new StockCache();

	}
	return instance;
    }

    /**
     * Add Item
     * <p>
     * Takes in an item object and adds it to the arrayList
     *
     * @param myItem -- Item to be added.
     * @return boolean -- true if successful, false otherwise
     *
     */
    public static boolean addItem(Item myItem) {
	getInstance();
	if (instance != null) {
	    instance.stock.add(myItem);
	    return true;
	}//instance was null
	return false;
    }

    /**
     * Prints Arraylist
     * <p>
     * Prints out the contents of the inventory in a tidy fashion.
     */
    public static void printItems() {
	System.out.println("");
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	System.out.println("    CURRENT INVENTORY    ");
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	System.out.println("----------------------------");

	for (Item i : instance.stock) {

	    System.out.println(i);
	}
	System.out.println();

    }

    /**
     * Clears the Arraylist
     * <p>
     * Wipes the contents of the arraylist before refresh
     */
    public static void emptyCache() {
	getInstance();
	instance.stock.clear();

    }

    /**
     * get item
     * <p>
     * pulls the item (corresponding to given ID) from the cache, if its a miss,
     * returns null.
     */
    public static Item getItem(int itemID) {
	//create a fake item with teh matching id, this located the real item in the array.

	int i = 0;
	int index = -1;
	for (Item itemB : instance.stock) {
	    if (itemB.getID() == itemID) {
		index = i;
		break;
	    }
	    i++;

	}

	//	    System.out.println("index is: " + index);
	if (index < 0) {
	    return null;
	}
	return instance.stock.get(index);
    }

    /**
     * save transactions
     * <p>
     * Serializes and stores an array of transactions, to be executed later.
     */
    public static boolean saveTransactions(ArrayList<Transaction> trans) {
	try {
	    System.out.println("Transactions before!!");
	    for (Transaction t : trans) {
		System.out.println(t.toString());
	    }
	    FileOutputStream fileOut = new FileOutputStream("backup/transactions.ser");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(trans);
	    out.close();
	    fileOut.close();
	    System.out.printf("Serialized transactions are stored in  transactions.ser");
	} catch (IOException i) {
	    i.printStackTrace();
	    return false;
	}

	return true;

    }

    public static ArrayList<Transaction> loadTransactions() {
	ArrayList<Transaction> trans = null;
	try {
	    FileInputStream fileIn = new FileInputStream("backup/transactions.ser");
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    trans = (ArrayList<Transaction>) in.readObject();
	    in.close();
	    fileIn.close();
	} catch (IOException i) {
	    i.printStackTrace();
	    return null;
	} catch (ClassNotFoundException c) {
	    System.out.println("Transaction class not found");
	    c.printStackTrace();
	    return null;
	}
	System.out.println("Transactions After!!");
	for (Transaction t : trans) {
	    System.out.println(t.toString());
	}
	return trans;
    }

}

// TODO: tostring Method
// TODO

