package pointofsalesystem;

public class LoginController {

    private LoginUI gui;            //create a LoginUI object as data field
    private PurchaseSession model;

    public LoginController() {
	gui = new LoginUI(this);    //pass the LoginController to the gui object
	gui.setVisible(true);       //display login ui
    }

    public void addModel(PurchaseSession ses) {
	model = ses;
    }

    public void onLoginAttempt(String userID, String password) {
	//recieves login information from UI and passes it on to be verified
	int role = verifyLoginInfo(userID, password);
	System.out.println("role = "+role);
	if (role==2) {               //verifies login info to start POS ui
	    gui.validLogin();
	    switchToPOS(userID, password);
	} else if (role ==1||role == 0){
	    gui.validLogin();
	  switchToManager(userID, password);

	}
	    else {
	    gui.invalidLogin();
	}
    }

    private int verifyLoginInfo(String userId, String password) {
	//will contact session to verify
	PurchaseSession my_sess = new PurchaseSession(userId, password);
	int employeeRole = my_sess.login();
	//On valid login save the session as the UI's model
	this.addModel(my_sess);
	return employeeRole;

    }

    private void switchToPOS(String id, String pass) {
	gui.setVisible(false);
	PointOfSaleController pos = new PointOfSaleController(id, pass, model);
	gui = null;
    }
        private void switchToManager(String id, String pass) {
	    gui.setVisible(false);
	    ManagerController man = new ManagerController();
	    gui = null;
    }
}
