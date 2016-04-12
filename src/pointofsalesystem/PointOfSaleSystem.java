package pointofsalesystem;

/*

This is the final thingy
 */

public class PointOfSaleSystem {

    public static void main(String[] args) {

	int systemState = systemStartup();

	if(systemState==-1){
	    System.out.println("\nUnable to start POS System... Goodbye.");
	    return;
	}
	if(systemState==0){
	    System.out.println("\nOperating at limited capacity");
	}
	LoginController lc = new LoginController();     //create a LoginController object to generate UI

    }

    public static int systemStartup() {
	//state == 1: all good!
	//state == 0: some connection errors, still functional!
	//state ==-1: critical failure, cannot run POS system.
	System.out.println("Beginning Startup Procedure:");
	int state = 1;
	boolean failed = false;
	Database test = new Database();
	if (!test.isConnected() && state == 1) {
	    state = 0;
	    System.out.println("XXXXXX Database Unreachable!! Beginning in offline mode.");

	} else {
	    System.out.println("       Database connection... OK");
	}
	try {
	    Class.forName("creditcardauthenticator.CreditCardAuthenticator");
	    System.out.println("       Credit Card Service... OK");

	} catch (ClassNotFoundException ex) {
	    System.out.println("XXXXXX Credit Card service unreachable. Utilizing Cash Only mode.");
	    state = 0;
	}
	try {
	    Class.forName("taxcalculator.Tax_Calculator");
	    System.out.println("       Tax Calculator Service... OK");
	} catch (ClassNotFoundException ex) {
	    System.out.println("XXXXXX Tax Calculator Service  unreachable. Startup Failed.");
	    failed = true;
	}
	try {
	    Class.forName("rentalcalculator.RentalCalculator");
	    System.out.println("       Rental Calculator Service... OK");

	} catch (ClassNotFoundException ex) {
	    System.out.println("XXXXXX Rental Calculator Service unreachable. Startup Failed.");
	    failed = true;
	}
	if (failed) {
	    return -1;
	}

	return state;

    }





}
