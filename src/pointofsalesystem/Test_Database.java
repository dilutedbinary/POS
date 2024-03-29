package pointofsalesystem;



class Test_Database {

	public static void main(String [] args) {
		Database testdb = new Database("jfc216", "abc123");
		System.out.println(testdb.authenticateUser("jfc216", "abc123"));
		System.out.println("Authenticate User:" + testdb.authenticateUser("jfc216", "abc123"));
		testdb.updateCache();
		//Create new Users
		/*Address addr1 = new Address("123 Sunshine Lane","","Townville","123456");
		Address addr2 = new Address("51 Montclair","","Townville","123456");
		CreditCard credcard = new CreditCard("5424123412341234", "Miles Zwicky","03","18","354");
		
		User u1 = new User("TestCustomer","5553141234","5551239876","adfsd@gmail.com",addr1,addr1,credcard,11,1);
		User u2 = new User("TestCashier","5554969745","5554969745","cashier@gmail.com",addr1,addr1,credcard,21,1);*/
                User u1 = testdb.getUser(1);
                User u2 = testdb.getUser(11);
		
		Transaction my_trans = new Transaction(u1,u2);
		
		//Valid Item ids
		//1
		//11
		//21
		//31
		//41
		//Pull some Items from the database
		Item i1 = testdb.getItemInfo(11);
		Item i2 = testdb.getItemInfo(21);
		Item i3 = testdb.getItemInfo(31);
		System.out.println(i1.toString());
		int amounOfItem1 = testdb.getStock(i1.getID()); 
		System.out.println(amounOfItem1+" in stock...\n\n");
		//public void addItem(Quadruple<Item, Integer, Integer> t){
		//Package the items in Quadruples
		Quadruple<Item,Integer,Integer, Integer> trip1 = new Quadruple(i1,4,0, 0);
		Quadruple<Item,Integer,Integer, Integer> trip2 = new Quadruple(i2,2,0, 0);
		Quadruple<Item,Integer,Integer, Integer> trip3 = new Quadruple(i3,1,0, 0);
		
		my_trans.addItem(trip1);
		my_trans.addItem(trip2);
		my_trans.addItem(trip3);
		
		//Ok save the transaction
		testdb.saveTransaction(my_trans);
		amounOfItem1 = testdb.getStock(i1.getID()); 
		System.out.println(amounOfItem1+" now in stock...\n\n");
		
		
		//System.out.println(testdb.checkConnectionOpen());
		//3rd party tax calc test code
		//Tax_Calc_Interface test = new Tax_Calc_Interface();
		//System.out.println(test.calculateTax());

	}
};
