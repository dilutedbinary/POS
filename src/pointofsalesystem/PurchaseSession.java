package pointofsalesystem;

/** Class which represents a PurchaseSession. */

import java.io.PrintWriter;
public class PurchaseSession {
  
    private String mUserID, mPassword;
    private Transaction mCurrent_Transaction;
    private Transaction mFinalize_Transaction;
    private Database mDB;
    private PointOfSaleController posc;

    
    /** Constructor for PurchaseSession. */
    public PurchaseSession(String userID, String password) {
      mUserID = userID;
      mPassword = password;
      mDB = new Database();
      newTransaction(1,21); //TODO: ADD A WAY TO PASS IN CASHIER AND CUSTOMER IDS - Also might want to have the UI have a button to wipe the current transaction and create a new one
    }
    
    public void addController(PointOfSaleController cont){
        posc = cont;
    }
    
//    public void removeItem(int id){
//       Quadruple<Item, Integer, Integer, Integer> t = mCurrent_Transaction.getItemByID(id)
//        mCurrent_Transaction.removeItem(t);
//    }
    
    public void newTransaction(int customer_id, int cashier_id) {
		User u1 = mDB.getUser(customer_id);
                User u2 = mDB.getUser(cashier_id);
                mCurrent_Transaction = null;
		mCurrent_Transaction = new Transaction(u1,u2);
                if(mCurrent_Transaction.getQuadrupleList() == null){
                    System.out.println("is null");
                }
	}
    

    /** Logs a user into the database. */
    public int login(String userId, String password) {
      mDB = new Database();
      return mDB.authenticateUser(userId,password);
    }
    
     /** Logs a user into the database using mUserId an mPassword. */
    public int login() {
      mDB = new Database();
      return mDB.authenticateUser(mUserID, mPassword);
    }
    
    /** Adds an item to the current transaction. */
    public Quadruple<Item, Integer, Integer, Integer> addItem(int id, int period){
      Item item = mDB.getItemInfo(id);
      Quadruple<Item, Integer, Integer, Integer> t;
      if(period > 0) {
        t = new Quadruple<Item, Integer, Integer, Integer>(item, 1, 1, period);
      }
      else if (period == 0) {
        t = new Quadruple<Item, Integer, Integer, Integer>(item, 1, 0, period);
      }
      else {
          item.setPrice(item.getPrice()*-1);
          t = new Quadruple<Item, Integer, Integer, Integer>(item, 1, 2, period);
          
      }
      mCurrent_Transaction.addItem(t);
      return t;
    }
    
    public Quadruple[] getLineItems(){
        Quadruple [] out = mCurrent_Transaction.getQuadrupleList().toArray(new Quadruple[mCurrent_Transaction.getQuadrupleList().size()]);
        System.out.println("this length is: "+ out.length);
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
    public void preCheckout(String tempID, String total){
        CheckOutScreenController coController = new CheckOutScreenController(this, tempID, total);
    }
    //TODO: CHANGE THIS TO NOT ACCEPT A STRING ONCE USERS ARE IMPLEMENTED
    public void checkout(String tempID) {  
		//Save the transaction to the Database
		mDB.saveTransaction(mCurrent_Transaction);
		//Write this stuff to a text file
		//Putting it in a try statment will automatically close it after finishing(Java 7 or later)
		try(PrintWriter out = new PrintWriter("receipt_"+System.currentTimeMillis()+".txt")) {
		out.println(mCurrent_Transaction.toString(tempID));
	} catch(java.io.FileNotFoundException ex) {
		System.out.println("ERROR - Could not print receipt to file!!");
	}
                
                posc.newPurchaseSession();
                newTransaction(0, mDB.getCurrentUserID);
                System.out.println("after trans");
                
	}
}

