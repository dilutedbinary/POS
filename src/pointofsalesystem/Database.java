package pointofsalesystem;

/**
 * @author      Jamie Cahill jfc216@lehigh.edu
 * @version     .1
 * @since       2-25-2016
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Database {

	private boolean verbose = false;


	/**
	 * Holds the user type(admin, manager,...) of the user who instantiated this Database object
	 * Admin = 0, Manager = 1, Cashier = 2, Customer = 3
	 */
	private int usertype;

	/**
	 * Holds the userid of the user who instantiated this Database object
	 */
	private int userid;

	/**
	 * Connection object through which database queries are made
	 */
	private Connection conn;

	/**
	 * Objects through which SQL queries are made and returned
	 */
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement preStatement;


	/**
	* A local copy of the information stored in the Item table
	*/

	private StockCache cache;
	/**
	 * Info need to connect to the database
	 */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net:3306/pos_database";
	private static final String USER = "bb7e7b52fb7bbe";
	private static final String PASS = "b8ef43e3";

	/**
	 * Creates a Database object
	 * <p>
	 * The Database object will facilitate all reads and writes to the database.
	 * When creating a database object a username and password are required in order
	 * to the set appropriate read and write permissions of the current user
	 * (i.e. We don't want a cashier to be able to modify a manager's user profile)
	 *
	 * @param username -- username of the user accessing the database
	 * @param password -- password of the user accessing the database
	 */
	public Database(String username, String password) {
		//Load the JDBC Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Could not load MySQL JDBC Driver - do you have the .jar file set up correctly?");
			ex.printStackTrace();
			return;
		}

		//Connect to the database
		if (!this.connect()) {
			System.out.println("Error - connection Failed");
		} else {


			//The connection should now be established
			//Let's query for the user credentials
			try {
				stmt = conn.createStatement();
				//Query for a person with the specified username and password
				rs = stmt.executeQuery("SELECT * FROM person WHERE USERNAME = '" + username + "' AND USER_PASSWD = '" + password + "';");
				//Check to see if the user exists and set usertype accordingly
				rs.first();
				usertype = Integer.parseInt(rs.getString("USER_TYPE"));
				//Save the userid of the person who created the account for later use
				userid = Integer.parseInt(rs.getString("PERSON_ID"));
				this.disconnect();
			} catch (SQLException ex) {
				System.out.println("ERROR - Invalid username and password!!");
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				this.disconnect();
			}
		}
	}
	
	
	//constructor for testing the database
    public  Database() {
		//Load the JDBC Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Could not load MySQL JDBC Driver - do you have the .jar file set up correctly?");
			ex.printStackTrace();
			return;
		}

		//Connect to the database
		if (!this.connect()) {
			System.out.println("Error - connection Failed");
		} 
return;		

		    
	}


	/**
	 * Returns whether or not the Database object can connect to the database
	 *
	 * @param none
	 * @return true if the a connection can be made, false otherwise
	 */
	public boolean isConnected() {
		boolean flag = this.connect();
		this.disconnect();
		return flag;
	}


	/**
	 * Returns whether or not the Database is currently connected!
	 *
	 * @param none
	 * @return true if the a connection is open, false if it is closed
	 */
	public boolean checkConnectionOpen() {
		try {
			if(conn==null){
				return false;
			}
			//flag = true if conncetion is open
			boolean flag = !(conn.isClosed());
			if(verbose) {
				if (flag) {
					System.out.println("connection is open");

				} else {
					System.out.println("connection is closed");

				}
			}
			return flag;
		} catch (SQLException ex) {
			System.out.println("ERROR - Could not check state!!");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return false;
	}


	/**
	 * Returns whether or not a user with the passed in username and password exists within the database
	 *
	 * @param username -- the username to be checked
	 * @param password -- the password to be checked
	 * @return -2 if cant connect, -1 if non user, 0 for admin, 1 for manager, 2 for cachier, 3 for customer
	 */
	public int authenticateUser(String username, String password) {
		if (!this.connect()) {
			this.disconnect();

		    //connection error
			return -2;
		}

		try {
			stmt = conn.createStatement();
			//Query for a person with the specified username and password
			rs = stmt.executeQuery("SELECT * FROM person WHERE USERNAME = '" + username + "' AND USER_PASSWD = '" + password + "';");
			//Try to extract data from teh query, can be anything but in this case let's get person_id
			//An exception will be thrown if the query is empty
			if(verbose)
				printResultSet(rs);


			if(!rs.next()){
			    this.disconnect();

			    return -1;
			}

			//System.out.println("Printed");
			usertype = Integer.parseInt(rs.getString("USER_TYPE"));
			//System.out.println("type set");
			this.disconnect();
			//System.out.println("disconnected...");

			return usertype;
		} catch (SQLException ex) {
			this.disconnect();
			return -2;
		}

	}

	/**
	 * Connects the Database object to the actual database. By convention the database connection should be opened and
	 * then closed on every to this Database object to ensure there aren't any connections left open
	 *
	 * @param none
	 * @return true if a connection was established, false otherwise
	 */
	private boolean connect() {
		//Setup the connection to the server
		//rs=null;
		//stmt=null;
		try {
			//If you are currently connected, dont bother opening another...
			if(checkConnectionOpen()){
				return true;
			}

			conn = DriverManager.getConnection(DB_URL, USER, PASS);		
			if (!conn.isClosed()) {
				return true;

			} else {
				return false;
			}
		} catch (SQLException ex) {
			System.out.println("ERROR - Could not connect to server!!!");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}
	}

	/**
	 * Disconnects the Database object from the actual database. By convention the database connection should be opened and
	 * then closed on every call to this Database object to ensure there aren't any connections left open
	 *
	 * @param none
	 */
	private void disconnect() {
		
		try {
			if(preStatement != null && !preStatement.isClosed())
				preStatement.close();
		}
		catch (SQLException ex) {
			System.out.println("Prestatement failed to close...");

		}

		try {
			if(stmt != null && !stmt.isClosed()){
				stmt.close();
			}
		} catch (SQLException ex) {
			System.out.println("Statement failed to close...");

		}


		//Close the ResultSet object

		try {
			if(rs!=null&&!rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException ex) {
			System.out.println("RS failed to close...");

		}

		//Close the Connection object

		try {
			if (!conn.isClosed()) {
				conn.close();

				//System.out.print("Database is closed?? : ");
			//	System.out.print(conn.isClosed());
		//		System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("Connection Failed to close..");


		}
	}

	/**
	 * The finalize method gets called whenever the Java garbage collector collects an object.
	 *  In this case I have overriden it to ensure that it closes any open connections before the Database gets garbage collected
	 *
	 * @param none
	 */
	@Override
	protected void finalize() {
		this.disconnect();
	}

	/**
	 * Returns information about a specified item
	 * <p>
	 * Returns an Item object which contains all the info stored by the database
	 * on the specified itemid
	 *
	 * @param itemid id of the item whose info is being returned
	 * @return itemObject
	 */
	public Item getItemInfo(int itemID) {
		StockCache cache = StockCache.getInstance();
		Item result = cache.getItem(itemID);
		if(result!=null){
			return result;
		}
		if(verbose)
			System.out.println("cache miss!");

		if (!this.connect()) {
			return null;
		}
		try {
	    //Construct the query
			stmt = conn.createStatement();
			String query  =  "SELECT * FROM item WHERE item_id = '" + Integer.toString(itemID) + "';";
	    //Run the query
			rs = stmt.executeQuery(query);
	    //Parse out the info
			rs.first();
			String name = rs.getString("NAME");
			int tax_type = Integer.parseInt(rs.getString("TAX_TYPE"));
			double price = Double.parseDouble(rs.getString("PRICE"));
			String desc = rs.getString("DESCRIPTION");
			
                        //int period = Integer.parseInt(rs.getString("PERIOD"));

	    //Create an Item object with the values from the Database and return
			Item i = new Item(itemID, name, price, tax_type, desc);

			this.disconnect();
			return i;
		} catch (SQLException ex) {
			System.out.println("Error in Database.getItemInfo!!");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			this.disconnect();
		}
		return null;
	}


    /**
     * Returns information about a specified item. This variant assumes that the Database object already has a connection open to the database and does not open or close any connections.
     * As such it is intended for use only within the Database object itself
     * <p>
     * Returns an Item object which contains all the info stored by the database
     * on the specified itemid
     *
     * @param itemid id of the item whose info is being returned
     * @return itemObject
     */
    //@Overload
    private Item getItemInfo(int itemID,boolean already_connected) {
    	StockCache cache = StockCache.getInstance();
    	Item result = cache.getItem(itemID);
    	if(result!=null){
    		return result;
    	}
    	if(verbose)
    		System.out.println("cache miss!");

    	try {
			    //Construct the query
    		stmt = conn.createStatement();
    		String query  =  "SELECT * FROM item WHERE item_id = '" + Integer.toString(itemID) + "';";
			    //Run the query
    		rs = stmt.executeQuery(query);
			    //Parse out the info
    		rs.first();
    		String name = rs.getString("NAME");
    		int tax_type = Integer.parseInt(rs.getString("TAX_TYPE"));
    		double price = Double.parseDouble(rs.getString("PRICE"));
    		String desc = rs.getString("DESCRIPTION");
                int period = Integer.parseInt(rs.getString("PERIOD"));

			    //Create an Item object with the values from the Database and return
    		Item i = new Item(itemID, name, price, tax_type, desc, period);


    		return i;
    	} catch (SQLException ex) {
    		System.out.println("Error in Database.getItemInfo!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	return null;
    }
    
    
    /**
	 * Returns an array list of credit cards ascociated with the specified user
	 * 
	 * @param userid userID of the person's whose CreditCards we are searching for
	 * @return Arraylist of CreditCard objects ascociated with the user
	 */
    public ArrayList getCreditCard(int userid) {
    	ArrayList<CreditCard> al = new ArrayList();

    	if (!this.connect()) {
    		return al;
    	}

    	try{ 
	    //Insert the item into the database
    		String query = "SELECT * FROM CREDIT_CARD WHERE USERID = ?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		rs = preStatement.executeQuery();

    		while(rs.next()) {
    			String name = rs.getString("CARDHOLDERNAME");
    			String month = rs.getString("EXPMONTH");
    			String year = rs.getString("EXPYEAR");
    			String cardnumber = rs.getString("CARDNUMBER");
    			String cvc = rs.getString("CVC");
    			CreditCard cred = new CreditCard(cardnumber,name,month,year,cvc);
    			al.add(cred);
    		}
    		this.disconnect();
    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.getCreditCard!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return al;
    }
    
    /**
     * Stores the given creditcard on the database. The creditcard will be ascociated with the given userid
     * 
     * @param userid the userid of the person to whom the creditcard belongs
     * @param cred CreditCard object to be stored
     * @return true if the creditcard was sucessfully saved to the database, false if the creditcard already exists within the database or the method fails
     */
    public boolean storeCreditCard(int userid, CreditCard cred) {
	//Establish a connection to the database
    	if (!this.connect()) {
    		return false;
    	}

    	try{
	    //First make sure the credit card isn't already saved in the database
    		String query = "SELECT * FROM CREDIT_CARD WHERE CARDNUMBER=? AND CARDHOLDERNAME=? AND EXPMONTH=? AND EXPYEAR=? AND CVC=?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setString(1,cred.getcardnumber());
    		preStatement.setString(2,cred.getname());
    		preStatement.setString(3,cred.getmonth());
    		preStatement.setString(4,cred.getyear());
    		preStatement.setString(5,cred.getcvc());
    		rs = preStatement.executeQuery();
    		if(rs.next()){
    			System.out.println("Warning in Database.storeCreditCard - CreditCard already exists within Database");
    			return false;
    		}

	    //Since it doesn't exist within the Database we can store it within the database
    		query = "INSERT INTO CREDIT_CARD (USERID,CARDNUMBER,CARDHOLDERNAME,EXPMONTH,EXPYEAR,CVC) VALUES (?,?,?,?,?,?)";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		preStatement.setString(2,cred.getcardnumber());
    		preStatement.setString(3,cred.getname());
    		preStatement.setString(4,cred.getmonth());
    		preStatement.setString(5,cred.getyear());
    		preStatement.setString(6,cred.getcvc());
    		preStatement.executeUpdate();

    		this.disconnect();
    		return true;
    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.storeCreditCard!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    		return false;
    	}
    }
    
    /**
     * Removes the specified CreditCard from the database(NOTE: Doesn't check to see if the card exists within the Database)
     * 
     * @param cred CreditCard to be removed from the Database
     * @return true if sucessfully removed, false if the method fails
     */
    public boolean removeCreditCard(CreditCard cred) {
	//Establish a connection to the database
    	if (!this.connect()) {
    		return false;
    	}

    	try{
	    //First make sure the credit card isn't already saved in the database
    		String query = "DELETE FROM CREDIT_CARD WHERE CARDNUMBER=? AND CARDHOLDERNAME=? AND EXPMONTH=? AND EXPYEAR=? AND CVC=?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setString(1,cred.getcardnumber());
    		preStatement.setString(2,cred.getname());
    		preStatement.setString(3,cred.getmonth());
    		preStatement.setString(4,cred.getyear());
    		preStatement.setString(5,cred.getcvc());
    		preStatement.executeUpdate();
    		this.disconnect();
    		return true;
    	}

    	catch (SQLException ex) {
    		System.out.println("Error in Database.removeCreditCard!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    		return false;
    	}
    }
    
    /**
     * Adds a new item to the Database
     * <p>
     * Takes an Item object and creates a new entry in the database for that item.
     * This method returns the unique itemid created by the database for the newly created item.
     *
     * @param i new Item to be stored in the databse
     * @return unique itemid created by the database for the new item
     */
    public int createNewItem(Item i,int stock) {
	//Check to make sure the item doesn't already have a valid item ID(if it has a valid ID it probably is already in the database)
    	if(i.getID() > 0) {
    		System.out.println("ERROR in Database.createNewItem - specified Item already has a valid itemID!");
    		return -1;
    	}

    	if (!this.connect()) {
    		return -1;
    	}

    	try{ 
	    //Insert the item into the database
    		String query = "INSERT INTO item (PRICE,DESCRIPTION,NAME,TAX_TYPE,STOCK) VALUES (?,?,?,?,?);";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setBigDecimal(1,BigDecimal.valueOf(i.getPrice()));
    		preStatement.setString(2,i.getDescription());
    		preStatement.setString(3,i.getName());
    		preStatement.setInt(4,i.getTaxType());
    		preStatement.setInt(5,stock);
    		preStatement.executeUpdate();

	    //Now using the same information extract the item that was just added to determine the itemid assigned to it by the database
    		query = "SELECT * FROM item WHERE PRICE = ? AND DESCRIPTION = ? AND NAME = ? AND TAX_TYPE = ? AND STOCK = ?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setBigDecimal(1,BigDecimal.valueOf(i.getPrice()));
    		preStatement.setString(2,i.getDescription());
    		preStatement.setString(3,i.getName());
    		preStatement.setInt(4,i.getTaxType());
    		preStatement.setInt(5,stock);
    		rs = preStatement.executeQuery();

	    //Parse out the itemid and return
    		rs.first();
    		int itemid = rs.getInt("ITEM_ID");
		updateCache();
    		this.disconnect();
    		return itemid;
    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.createNewItem!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}

    	return -1;
    }
    
    public void removeItem(int itemid) {
    	if(itemid <= 0) {
    		System.out.println("ERROR in Database.removeItem - invalid itemID!");
    		return;
    	}

    	if (!this.connect()) {
    		return;
    	}

    	try{ 
	    //Insert the item into the database
    		String query = "DELETE FROM item WHERE item_id = ?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,itemid);
    		preStatement.executeUpdate();
    		this.disconnect();
    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.removeItem!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return;
    }
    
    /**
     * Returns an ArrayList of all Transactions where the passed in userid was the recorded customer
     * 
     * 
     * @param userid Userid of the customer whose transactions we are retreiving
     * @return ArrayList of Transactions associted with the given user, null if the operation fails or it the user is not found
     */
    public ArrayList<Transaction> getUserTransactions(int userid) {
        //TODO: Add permission checking things here
        
        //Establish a connection to the database
    	if (!this.connect()) {
    		return null;
    	}
        //First build a list of transaction ids we'll need to look up
        try{
	    //Query the database for the transaction ascociated with the transaction id
    		String query = "SELECT * FROM transaction WHERE customer_id = ?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		rs = preStatement.executeQuery();
                ArrayList<Integer> transaction_ids = new ArrayList();
                while(rs.next()) {
                    int tid = rs.getInt("Transaction_id");
                    transaction_ids.add(tid);
                }
             //Now lookup all these transactions from the database
                ArrayList<Transaction> transactions = new ArrayList();
                
                for(int i = 0; i < transaction_ids.size(); i++){
                    transactions.add(getTransactionInfo(transaction_ids.get(i)));
                }
                this.disconnect();  //to be safe
                return transactions;
        }
                catch (SQLException ex) {
    		System.out.println("Error in Database.getTransactionInfo!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return null;
    }
    
    
    /**
     * Returns information about the specified Transaction
	 * <p>
	 * Returns a Transaction object containing all the information about the transaction with the passed in Transaction id
	 *
	 * @param transactionid id number of the transaction being looked up
	 * @return Transaction object containing information about the the specified transaction
	 */
    public Transaction getTransactionInfo(int transactionid) {
    	if(transactionid < 0) {
    		System.out.println("ERROR in Database.getTransactionInfo - transactionid is < 0");
    		return null;
    	}
        
        if (!this.connect()) {
    		return null;
    	}

    	try{
	    //Query the database for the transaction ascociated with the transaction id
    		String query = "SELECT * FROM transaction WHERE transaction_id = ?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,transactionid);
    		rs = preStatement.executeQuery();

	    //Extract the info from the query
    		rs.first();
    		int employee_id = rs.getInt("EMPLOYEE_ID");
    		int customer_id = rs.getInt("CUSTOMER_ID");
    		Timestamp time = rs.getTimestamp("trans_date");
                 User customer = this.getUser(customer_id);
                User employee = this.getUser(employee_id);
                Transaction t = new Transaction(transactionid,customer,employee);
               if (!this.connect()) {//We need to reconnect as the above methods disconnect us from the database
    		return null;
    	}

	    //Now we need to query the transaction _item table for all the items asociated with the transaction
    		query = "SELECT * FROM transaction_item WHERE transaction_id = ?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,transactionid);
    		rs = preStatement.executeQuery();
	

    		while(rs.next()) {
    			int item_id = rs.getInt("ITEM_ID");
    			int qty = rs.getInt("QUANTITY");
    			int type = rs.getInt("TYPE");
    			Item i = this.getItemInfo(item_id,true);
    			Quadruple<Item,Integer,Integer, Integer> quad = new Quadruple(i,qty,type, 0);
    			t.addItem(quad);
    		}

    		this.disconnect();
    		return t;

    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.getTransactionInfo!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return null;
    }
    
    
    /**
     * Stores the passed in User object to the database
     * 
     * @param u User to be stored on the database
     * @return the userid of the new the user is sucessfully saved to the database, -1 if the user already exists within the database or the operation fails
     */
    public int storeUser(User u){
        
          if(this.usertype >= u.getType() && this.usertype != 0) {
         System.out.println("Warning in Database.storeUser - Invalid permission to create a new user of this type");   
        return -1;
        }
        
        //Establish a connection to the database
    	if (!this.connect()) {
    		return -1;
    	}
        
    	try{
	    //First make sure the user isn't already saved in the data
    		String query = "SELECT * FROM person WHERE username=? AND user_passwd=?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setString(1,u.getUsername());
    		preStatement.setString(2,u.getPassword());
    		rs = preStatement.executeQuery();
    		if(rs.next()){
    			System.out.println("Warning in Database.storeUser - User already exists within Database");
                        this.disconnect();
    			return -1;
    		}

	    //Since it doesn't exist within the Database we can store it within the database
    		query = "INSERT INTO PERSON (username,user_passwd,user_type,name,email,home_phone,mobile_phone) VALUES (?,?,?,?,?,?,?)";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setString(1,u.getUsername());
    		preStatement.setString(2,u.getPassword());
    		preStatement.setInt(3,u.getType());
    		preStatement.setString(4,u.getName());
    		preStatement.setString(5,u.getEmail());
    		preStatement.setString(6,u.getPhone());
                preStatement.setString(7,u.getMobile());
    		preStatement.executeUpdate();
            
            
                
               //Now look up the new user and return the userid assigned by the database to the new user
               query = "SELECT * FROM person WHERE username=? AND user_passwd=?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setString(1,u.getUsername());
    		preStatement.setString(2,u.getPassword());
    		rs = preStatement.executeQuery();
    		int new_id = rs.getInt("PERSON_ID");
                u.setId(new_id); //might as well set the id of the new user to what the database assigned it

               //Now we need to save the username and password associated with this fool
                this.disconnect();
                this.storeCreditCard(new_id,u.getCreditCard());
    		this.storeAddress(new_id,u.getBillingAddress(),1);
                this.storeAddress(new_id,u.getShippingAddress(),0);
    		return new_id;
    }
        	catch (SQLException ex) {
    		System.out.println("Error in Database.storeUser!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    		return -1;
    	}
    }
    
    /**
     * Stores the passed in address and associates it with the passed in userid
     * 
     * @param userid id associated with the address we are storing
     * @param addr  Address object we are storing to the database
     * @param ship_or_billing 0 if it is a shipping address, > 0 if is a billing address
     * @return true if the address is sucessfully saved to the database, false if the user already has an address associated with them or if the operation fails
     */
    private boolean storeAddress(int userid,Address addr,int ship_or_billing){
       
        //Just so it's one or zero once its in the database
       if(ship_or_billing != 0) {
           ship_or_billing =1;
       }
        
        //Establish a connection to the database
    	if (!this.connect()) {
    		return false;
    	}
        
        
        try{
	    //First make sure the user isn't already saved in the data
    		String query = "SELECT * FROM person_address WHERE person_id=?;";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		rs = preStatement.executeQuery();
    		if(rs.next()){
    			System.out.println("Warning in Database.storeAddress - User already has an address associated with them within Database");
                         this.disconnect();
    			return false;
    		}
                
          //Since it doesn't exist within the Database we can store it within the database
    		query = "INSERT INTO PERSON_ADDRESS (person_id,line1,line2,city,state,zip,ship_or_billing) VALUES (?,?,?,?,?,?,?)";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		preStatement.setString(2,addr.getLine1());
    		preStatement.setString(3,addr.getLine2());
                preStatement.setString(4,addr.getCity());
    		preStatement.setString(5,addr.getState());
                preStatement.setString(6,addr.getZip());
                preStatement.setInt(7,ship_or_billing);
    		preStatement.executeUpdate();
                this.disconnect();
                
    		
    		return true;
    }
        	catch (SQLException ex) {
    		System.out.println("Error in Database.storeAddress!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    		return false;
    	}
    }
    
    
    
    
    //Given the passed in userid ,returns a User object with info on that user
    //Read permissions must be checked!!!
    /**
     * Returns information about the specifed user
     *
     * @param userid of the user being looked up
     * @return User object containing information about the specified user, if the current user does not have read permission for the specified user a null pointer is returned intead
     */
    public User getUser(int userid) {
        if(userid < 0) {
    		System.out.println("ERROR in Database.getUser - userid is < 0");
    		return null;
    	}
        
       if(this.usertype >= userid && this.usertype != 0) {
            System.out.println("Warning in Database.getUser - Invalid permission to get this user's info");   
            return null;
        }
        
	 if (!this.connect()) {
             
    		return null;
    	}
         
         
         try{
	    //Query the database for the transaction ascociated with the transaction id
    		String query = "SELECT * FROM person WHERE person_id=?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		rs = preStatement.executeQuery();

	    //Extract the info from the query
    		rs.first();
    		String name = rs.getString("NAME");
    		String username = rs.getString("USERNAME");
                String passwd = rs.getString("USER_PASSWD");
    		int user_type = rs.getInt("USER_TYPE");
                String email = rs.getString("EMAIL");
                String home_phone = rs.getString("HOME_PHONE");
                String mobile_phone = rs.getString("MOBILE_PHONE");

	    //Now we need to get the addresses, credit card, and transactions associated with this user
                ArrayList<CreditCard> creditcards = this.getCreditCard(userid);
                 CreditCard cred = null;
                if(creditcards != null && creditcards.size() != 0){
                    cred =(CreditCard) this.getCreditCard(userid).get(0);
                }
                Address addr1 = null;
                Address addr2 = null;
                Address[] addresses = this.getAddress(userid);
                if(addresses != null && addresses.length == 2){
                    addr1 = addresses[0];
                    addr2 = addresses[1];
                }

                User got_user = new User(name,home_phone,mobile_phone,email,addr1,addr2,cred,userid,user_type,username,passwd);
 
    		this.disconnect();
    		return got_user;

    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.getUser!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
           return null;
    }
    
    /**
     * Returns the billing and shipping address of the associated userid in an array in that order
     * 
     * 
     * @param userid userid of the user whose addresses we are looking up
     * @return array of Addresses with two addresses, the first is the billing address and the second is the shipping address, if the address doesn't exist then null is returned
     */
    private Address[] getAddress(int userid) {
         if (!this.connect()) {
    		return null;
    	}
       
         
         try{
             Address shipping = null;
             Address billing = null;
	    //Query the database for the transaction ascociated with the transaction id
    		String query = "SELECT * FROM person_address WHERE person_id=?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		rs = preStatement.executeQuery();
                rs.first();
                String line1 = rs.getString("LINE1");
                String line2 = rs.getString("LINE2");
                String city = rs.getString("city");
                String state = rs.getString("State");
                String zip = rs.getString("zip");
                int ship_or_bill =rs.getInt("ship_or_billing");
                
                if(ship_or_bill == 0) { //Shipping address
                    shipping = new Address(line1,line2,city,zip,state);
                }
                else {
                    billing = new Address(line1,line2,city,zip,state);
                }
                //Get the next address
                rs.next();
                line1 = rs.getString("LINE1");
               line2 = rs.getString("LINE2");
                city = rs.getString("city");
                state = rs.getString("State");
                zip = rs.getString("zip");
                ship_or_bill =rs.getInt("ship_or_billing");
                
                if(ship_or_bill == 0) { //Shipping address
                    shipping = new Address(line1,line2,city,zip,state);
                }
                else {
                    billing = new Address(line1,line2,city,zip,state);
                }
                this.disconnect();
                Address[] addresses = new Address[]{billing,shipping};
                return addresses;
        }
    	catch (SQLException ex) {
    		System.out.println("Error in Database.getAddresses!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
        return null;
    }
    
    /**
     * Removes the specified user from the database along with any credit cards and addresses associated with them, transactions associated with them remain however 
     * 
     * 
     * @param userid of the person to be removed
     * @return true if the user was sucessfully removed, false otherwise
     */
    public boolean deleteUser(int userid){
           if(this.usertype >= userid && this.usertype != 0) {
            System.out.println("Warning in Database.deleteUser - Invalid permission to delete User");   
            return false;
        }
        
    	if (!this.connect()) {
    		return false;
    	}
        
    	try{ 
	    //Delete the person from the person table
    		String query = "DELETE FROM person WHERE person_id=?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		preStatement.executeUpdate();
                
             //Delete the addresses from the person_address table
                query = "DELETE FROM person_address WHERE person_id=?";
                preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		preStatement.executeUpdate();
                
             //Delete associated credit cards from the credit card table
                query = "DELETE FROM credit_Card WHERE userid=?";
                preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,userid);
    		preStatement.executeUpdate();
    		this.disconnect();
               return true;
    	}
    	catch (SQLException ex) {
    		System.out.println("Error in Database.removeItem!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return false;
        
        
    }
    
    public int getStock(int itemid) {
    	try {
	    //Construct the query
    		if (!this.connect()) {
    			return -1;
    		}
    		stmt = conn.createStatement();
    		String query  =  "SELECT * FROM item WHERE item_id = '" + Integer.toString(itemid) + "';";
	    //Run the query
    		rs = stmt.executeQuery(query);
	    //Parse out the info and return
    		rs.first();
    		int result = Integer.parseInt(rs.getString("STOCK"));
    		this.disconnect();

    		return result;
    	} catch (SQLException ex) {
    		System.out.println("ERROR in Database.getStock()!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    	}
    	return -1;
    }
    
    
    /**
     * Updates the database's local inventory cache with currently sold items and their current prices.
     * To be run at the start of the day.
     * <p>
     * Returns the number of items added, -1 for error.
     *
     * @return itemObject
     */
    public int updateCache() {

    	if (!this.connect()) {
    		return -1;
    	}

    	try {
    		StockCache cache = StockCache.getInstance();
    		cache.emptyCache();
    		stmt = conn.createStatement();
    		String query  =  "SELECT * FROM item";
	    //Run the query
    		rs = stmt.executeQuery(query);
    		int item_id;
    		double price;
    		String description;
    		String name;
    		int tax_type;
    		int itemCount = 0;
                int period;
    		while (rs.next()) {
    			item_id = rs.getInt("ITEM_ID");
    			price = rs.getDouble("PRICE");
    			tax_type = rs.getInt("TAX_TYPE");
    			description = rs.getString("DESCRIPTION");
    			name = rs.getString("NAME");
                        period = rs.getInt("PERIOD");
    			cache.addItem(new Item(item_id, name, price, tax_type, description, period));
    			itemCount++;
    		}
    		this.disconnect();

    		return itemCount;
    	} catch (SQLException ex) {
    		System.out.println("ERROR - Error Querying Database for Items");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());

    		this.disconnect();
    		return -1;
    	}

    }
    
    
    
    private void printResultSet(ResultSet resultSet) {

    	try {
    		ResultSetMetaData rsmd = resultSet.getMetaData();
    		int columnsNumber = rsmd.getColumnCount();
    		while (resultSet.next()) {
    			for (int i = 1; i <= columnsNumber; i++) {
    				if (i > 1) System.out.print(",  ");
    				String columnValue = resultSet.getString(i);
    				System.out.print(columnValue + " " + rsmd.getColumnName(i));
    			}
    			System.out.println("");
    		}
    	} catch (SQLException ex) {
    		System.out.println("ERROR - Error Printing Resultset!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());

    		this.disconnect();
    	}
    }
    
    /**
     * Saves all the information about the passed in Transaction object to the database
     * Returns the unique Transaction id that the database assigns to the transaction
     *
     * @param t Transaction object to be saved to the database
     * @return unique id given to the Transaction by the database, returns -1 on failure
     */
    public int saveTransaction(Transaction t) {
	// First we are creating an entry in the TRANSACTION table where we will need customerID, cashierID, and the date
    	int cashierid = t.getCashier().getId();
    	int customerid = t.getCustomer().getId();
    	long time = System.currentTimeMillis();
    	java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
    	int transaction_id;
	//Now perform the query to insert into the database
    	preStatement = null;

    	if (!this.connect()) {
    		return -1;
    	}

    	try {
	    //Construct the query
    		stmt = conn.createStatement();
    		String query  =  "INSERT INTO transaction (EMPLOYEE_ID,CUSTOMER_ID,TRANS_DATE) VALUES (?,?,?)";
	    //Run the query
	    //NOTE: We're using a preparedStaament here

    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,cashierid);
    		preStatement.setInt(2,customerid);
    		preStatement.setTimestamp(3, timestamp);
    		preStatement.executeUpdate();
	    //conn.commit();

	    	    //Now using the exact same same info query the database to get the unique transaction id given to the transaction
    		query = "SELECT * FROM transaction WHERE EMPLOYEE_ID = ? AND CUSTOMER_ID = ? AND TRANS_DATE = ?";
    		preStatement = conn.prepareStatement(query);
    		preStatement.setInt(1,cashierid);
    		preStatement.setInt(2,customerid);
    		preStatement.setTimestamp(3, timestamp);
    		rs = preStatement.executeQuery();

	    //Parse out the Transaction id
    		rs.first();
    		transaction_id = rs.getInt("TRANSACTION_ID");

	    //Now referencing this Transaction ID we need to insert into the transaction_item table one time for every unique item in the transaction specifying the item_id, quantity, type, price_sold,tax_amt
    		for (int i = 0; i < t.getQuadrupleList().size(); i++) {
		//Get the info we need
	//A is an Item, B is amount, C is a boolean stating whether or not it is a rental
    			int item_id = t.getQuadrupleList().get(i).getA().getID();
    			int qty = t.getQuadrupleList().get(i).getB();
    			int rent_or_buy = t.getQuadrupleList().get(i).getC();
			int period = t.getQuadrupleList().get(i).getD();
    			double price = t.getQuadrupleList().get(i).getA().getPrice();
//updating the inventory closes the connection...
    			if (!this.connect()) {
			    return -1;
    			}
			int contractID = 0;
						//now we need to store rental information (if it is a rental)
			if(period>=1){
			    if(verbose)
				System.out.println("processingrental");
			query = "INSERT INTO contract (RENTAL_LENGTH,RENTAL_RATE,RENTAL_START,LATE_FEE_RATE) VALUES (?,?,?,?)";
    			preStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    			preStatement.setInt(1,period);
    			preStatement.setDouble(2,.10);
    			preStatement.setString(3,""+System.currentTimeMillis());
    			preStatement.setDouble(4,.50);
			preStatement.executeUpdate();
			ResultSet rs = preStatement.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    contractID = rs.getInt(1);
			}
			}

		//Create a new query
		//query = "INSERT INTO transaction_item (TRANSACTION_ID,ITEM_ID,QUANTITY,TYPE,PRICE_SOLD) VALUES (" + transaction_id + "," + item_id + "," + qty + "," + rent_or_buy + "," + price + ");";
    			query = "INSERT INTO transaction_item (TRANSACTION_ID,ITEM_ID,QUANTITY,TYPE,PRICE_SOLD,contract_id) VALUES (?,?,?,?,?,?)";
    			preStatement = conn.prepareStatement(query);
    			preStatement.setInt(1,transaction_id);
    			preStatement.setInt(2,item_id);
    			preStatement.setInt(3,qty);
    			preStatement.setInt(4,rent_or_buy);
    			preStatement.setDouble(5,price);
			preStatement.setInt(6,contractID);
		//Execute the query
    			preStatement.executeUpdate();

    			if(!this.updateInventory(item_id,qty)) {
    				System.out.println("Error in saveTransaction when updating inventory");
    				preStatement.close();
    				return -1;
    			}
			


    		}

    		this.disconnect();
    		return transaction_id;
    	}

    	catch (SQLException ex) {
    		System.out.println("Error writing Transaction to database!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();

    	}

    	return -1;

    }


    public boolean updateInventory(int item_ID, int amount_sold) {

    	try{
    		int current_stock_amount = 0;
    		this.connect();
	    //Construct the query
    		stmt = conn.createStatement();
    		String query  =  "SELECT STOCK FROM ITEM WHERE ITEM_ID = '" + item_ID + "';";
	    //Run the query
    		rs = stmt.executeQuery(query);
    		rs.first();
    		current_stock_amount = rs.getInt("STOCK");
    		int new_stock_amount = current_stock_amount - amount_sold;



    		rs = stmt.executeQuery(query);
	    //Parse out the Transaction id
    		rs.first();

    		query  =  "UPDATE `pos_database`.`item` SET `STOCK`= '" + new_stock_amount + "' WHERE `ITEM_ID`='" + item_ID + "';";
    		stmt.executeUpdate(query);
    		this.disconnect();

    		return true;
    	}catch(SQLException ex){
    		System.out.println("Error writing Transaction to database!!");
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    		this.disconnect();
    		return false;
    	}
    }


    
    

};
