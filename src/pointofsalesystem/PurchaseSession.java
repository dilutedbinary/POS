package pointofsalesystem;

/** Class which represents a PurchaseSession. */

import java.io.PrintWriter;
public class PurchaseSession {
  
    private String mUserID, mPassword;
    private Transaction mCurrent_Transaction;
    private Transaction mFinalize_Transaction;
    private Database mDB;

    
    /** Constructor for PurchaseSession. */
    public PurchaseSession(String userID, String password) {
      mUserID = userID;
      mPassword = password;
      mDB = new Database(userID,password);
      newTransaction(1,21); //TODO: ADD A WAY TO PASS IN CASHIER AND CUSTOMER IDS - Also might want to have the UI have a button to wipe the current transaction and create a new one
    }
    
    public void newTransaction(int customer_id, int cashier_id) {

		User u1 = mDB.getUser(customer_id);
                User u2 = mDB.getUser(cashier_id);
		mCurrent_Transaction = new Transaction(u1,u2);
	}
    

    /** Logs a user into the database. */
    public boolean login(String userId, String password) {
      mDB = new Database(userId, password);
      return mDB.isConnected();
    }
    
     /** Logs a user into the database using mUserId an mPassword. */
    public boolean login() {
      mDB = new Database(mUserID, mPassword);
      return mDB.isConnected();
    }
    
    /** Adds an item to the current transaction. */
    public Triplet<Item, Integer, Integer> addItem(int id){
      Item item = mDB.getItemInfo(id);
      Triplet<Item, Integer, Integer> t;
      if((item.getRentalPeriod()) > 0) {
        t = new Triplet<Item, Integer, Integer>(item, 1, 1);
      }
      else if (item.getRentalPeriod() == 0) {
        t = new Triplet<Item, Integer, Integer>(item, 1, 0);
      }
      else {
          t = new Triplet<Item, Integer, Integer>(item, 1, 2);
      }
      mCurrent_Transaction.addItem(t);
      return t;
    }
    
    public Triplet[] getLineItems(){
        Triplet[] out = mCurrent_Transaction.getTripleList().toArray(new Triplet[mCurrent_Transaction.getTripleList().size()]);
        return out;
    }
    
    /** Gets the total of the transaction. */
    public double getTotal(){
      return mCurrent_Transaction.calculateTotal();
    }
    
    /** Gets the subtotal of the transaction. */
    public double getSubTotal(){
      return mCurrent_Transaction.calculateSubTotal();
    }
    
    /** Gets the tax of the transaction. */
    public double getTax(){
      return mCurrent_Transaction.getTax();
    }
    
    public String getCashierID(){
    	return mUserID;
    }
    public void preCheckout(String tempID){
        CheckOutScreenController coController = new CheckOutScreenController(this, tempID);
    }
    //TODO: CHANGE THIS TO NOT ACCEPT A STRING ONCE USERS ARE IMPLEMENTED
    public void checkout(String tempID) {  
		//Save the transaction to the Database
		mDB.saveTransaction(mCurrent_Transaction);
		//Write this stuff to a text file
		//Putting it in a try statment will automatically close it after finishing(Java 7 or later)
		try(PrintWriter out = new PrintWriter("receipt_"+System.currentTimeMillis()+".txt")) {
		out.println(mCurrent_Transaction.deprecatedtoString(tempID));
	} catch(java.io.FileNotFoundException ex) {
		System.out.println("ERROR - Could not print receipt to file!!");
	}
                
	}
}

