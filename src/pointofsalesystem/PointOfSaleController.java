package pointofsalesystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
 

 
public class PointOfSaleController {
    
    private PointOfSaleUI pos;          //data fields to be passed to the session
    private String userID;
    private String password; 
    private PurchaseSession model;
    
    
    public PointOfSaleController(String id, String pass){
        userID = id;
        password = pass;
        pos = new PointOfSaleUI(this);
       
        pos.setVisible(true);            //start POS ui
         pos.setID(id);  //TODO: GET RID OF THIS ONCE USERS ARE PROPERLY IMPLEMENTED
    }
    
    public PointOfSaleController(String id, String pass, PurchaseSession ses){
        userID = id;
        password = pass;
        pos = new PointOfSaleUI(this);
        pos.setVisible(true);            //start POS ui
        setModel(ses);
         pos.setID(id);  //TODO: GET RID OF THIS ONCE USERS ARE PROPERLY IMPLEMENTED
    }
    
    public void setModel(PurchaseSession ses){
        model = ses;
    }
    

    
/*
    public void addItem(String itemIDString){
        int id;
        Triplet<Item,Integer,Integer> itemInfo = null;
        Item item = null;
        int quantity = 0;
        if((id = Integer.getInteger(itemIDString)) == null){
            pos.displayError("Item ID invalid, not a number");
        }else{
            //tripple a = item b = in quant c = purchase type
            itemInfo = model.addItem();
            item = itemInfo.getA();
            quantity = item.Info.getB();
            // get item purchase type
            pos.addLineItem(item.getID().toString(), item.getName(), item.getPrice().toString(), quantity.toString());
        }
        
        
        
    }
  */

    public void createCustomer(String name, String phone, String mobile, String shipAdd, String billAdd, String creditcardString, String username, String password1, String password2){
        //call method in session to add to database and return ID number
        int idNum = 696969;
        //validation!!!
        String message = "New Customer created with id#: "+idNum;
        AlertScreen al = new AlertScreen(message);
        al.setVisible(true);
    }
    

    public void addItem(String itemIDString) {
        int test=0;
        
        try{
           test = (Integer.parseInt(itemIDString));
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
        }
        
        Triplet balls = model.addItem(test);
        
        Triplet[] newTable = model.getLineItems();
        populateTable(newTable);
    }
    
    public void populateTable(Triplet[] newTable){
        pos.clearTable();
        for(int i = 0; i < newTable.length; i++){
            Item balls = (Item)newTable[i].getA();
            int item_id = balls.getID();
            String item_name = balls.getName();
            double price = balls.getPrice();
            
            String priceS = price + "";
            String idS = item_id + "";
            /*
            String item_id = newTable[i].getA().getId();
            String item_name = newTable[i].getA().getName();
            String price = String.valueOf(newTable[i].getA().getPrice());
*/
            String qty = String.valueOf(newTable[i].getB());
            pos.addLineItem(idS, item_name, priceS, qty);
        }
    }
    

    
//    public void addReturnItem(String itemIDString){
//       int test;
//        
//        try{
//           test = (Integer.parseInt(itemIDString));
//        }catch(Exception ex){
//            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
//        }
//        
//        Triplet[] newTable = model.addReturnItem(test);
//        populateTable(newTable);
//    }
    
    public void addRentalItem(String itemIDString, int days){
        if(days < 1){
            ErrorScreen es = new ErrorScreen(days + " is not a valid number of rental days");
        }
        int test;
    }
        
//    public void addRentalItem(String itemIDString, String daysString){
//        int test = -1;
//        try{
//           test = (Integer.parseInt(itemIDString));
//        }catch(Exception ex){
//            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
//        }
//        
//        Triplet[] newTable = model.addRentalItem(test);
//        populateTable(newTable);
//    }
    
    public double getTotal(){
        return model.getTotal();
    }
    
    public double getSubTotal(){
       return model.getSubTotal();
    }
    
    public double getTax(){
        return model.getTax();
    }
    
    public void preCheckout(){
        model.preCheckout(userID);
    }
    
    public void checkout() {
		model.preCheckout(userID); //TODO: CHANGE THIS NOT TO ACCEPT A STRING ONCE USERS ARE IMPLEMENTED
                
		//Create a new POS Contrller to wipe the screen - WARNING: THIS IS A TERRIBLE MEMORY LEAK RIGHT NOW
		PurchaseSession newSession = new PurchaseSession(userID,password);
		pos.setVisible(false);
		PointOfSaleController newController = new PointOfSaleController(userID,password,newSession);
	}
//    public void removeItem(String itemID){
//        int test;
//        
//        try{
//           test = (Integer.parseInt(itemID));
//        }catch(Exception ex){
//            ErrorScreen es = new ErrorScreen(itemID + " is not a number");
//        }
//        
//        Triplet[] newTable = model.removeItem(test);
//        populateTable(newTable);
//    }

    void enterCustomerID(String idString) {
        int id = 0;
        try{
            id = Integer.parseInt(idString);
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(idString + " is not a number");
        }
        //pass customer Id to session
    }
    
    public PointOfSaleController getPOSC(){
        return this;
    }
    
    public void newPurchaseSession(){
        pos.setVisible(false);
        pos = new PointOfSaleUI(this);
        pos.setVisible(true);
        pos.setID(userID);
    }
    
}
