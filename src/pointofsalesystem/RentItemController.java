/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

public class RentItemController {
    
    private RentItemUI rentUI;
    private PurchaseSession rentSession;
    private String returnDate;
    
    
    public RentItemController(PurchaseSession ps){
        rentUI = new RentItemUI(this);
        rentUI.setVisible(true);
        //rentUI.run();
        rentSession = ps;
    }
    
    public Triplet addItem(String itemIDString) {
	return rentSession.addItem(Integer.parseInt(itemIDString));
}  
    public double getTotal(){
        return rentSession.getTotal();
    }
    
    public double getSubTotal(){
       return rentSession.getSubTotal();
    }
    
    public double getTax(){
        return rentSession.getTax();
    }
    
    public void checkout() {
		//rentSession.checkout(userID); //TODO: CHANGE THIS NOT TO ACCEPT A STRING ONCE USERS ARE IMPLEMENTED
		//Create a new POS Contrller to wipe the screen - WARNING: THIS IS A TERRIBLE MEMORY LEAK RIGHT NOW
		//PurchaseSession newSession = new PurchaseSession(userID,password);
		rentUI.setVisible(false);
		//PointOfSaleController newController = new PointOfSaleController(userID,password,newSession);
	}
    public void removeItem(int itemID){
        //idk man
    }
    
    
    
}
