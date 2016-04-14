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
    
    
//    public PointOfSaleController(String id, String pass){
//        userID = id;
//        password = pass;
//        pos = new PointOfSaleUI(this);
//       
//        pos.setVisible(true);            //start POS ui
//         pos.setID(id);  //TODO: GET RID OF THIS ONCE USERS ARE PROPERLY IMPLEMENTED
//         model.addController(this);
//    }
    
    public PointOfSaleController(String id, String pass, PurchaseSession ses){
        userID = id;
        password = pass;
        pos = new PointOfSaleUI(this);
        pos.setVisible(true);            //start POS ui
        setModel(ses);
         pos.setID(id);  //TODO: GET RID OF THIS ONCE USERS ARE PROPERLY IMPLEMENTED
         model.addController(this);
    }
    
    public void setModel(PurchaseSession ses){
        model = ses;
    }
    
    public String getCashiereID(){
        return userID;
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
        
        Quadruple balls = model.addItem(test, 0);
        
        Quadruple[] newTable = model.getLineItems();
        populateTable(newTable);
    }
    
    public void populateTable(Quadruple[] newTable){
        pos.clearTable();
        
        
        //hello
        //System.out.println("# items"+newTable.length);
        
        for(int i = 0; i < newTable.length; i++){
            Item balls = (Item)newTable[i].getA();
            int item_id = balls.getID();
            String item_name = balls.getName();
            double price = balls.getPrice();
            
            String transaction = "";
            int typeID = (Integer)newTable[i].getC(); 
            
            System.out.println("balls2: "+typeID);
            
            if(typeID == 0){
                //sale
                transaction = "Sale";
            }else if(typeID == 1){
                //rental
                transaction = "Rental";
                int poop = (Integer)newTable[i].getD(); 
                
            }else if(typeID == 2){
                //return
                price *= -1;
                transaction = "Return";
            }
            
            String priceS = price + "";
            String idS = item_id + "";
            /*
            String item_id = newTable[i].getA().getId();
            String item_name = newTable[i].getA().getName();
            String price = String.valueOf(newTable[i].getA().getPrice());
*/
            String qty = String.valueOf(newTable[i].getB());
            pos.addLineItem(idS, item_name, priceS, qty, transaction);
        }
    }
    
//    public void removeItem(String idString){
//        int test = 69;
//        
//        try{
//           test = (Integer.parseInt(itemIDString));
//        }catch(Exception ex){
//            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
//            return;
//        }
//        
//        Quadruple balls = model.removeItem(test);
//        
//        Quadruple[] newTable = model.getLineItems();
//        populateTable(newTable);
//    }
    
    public void addReturnItem(String itemIDString){
       int test = 69;
        
       //System.out.println("returning Item");
       
        try{
           test = (Integer.parseInt(itemIDString));
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
            return;
        }
        
        Quadruple balls = model.addItem(test, -1);
        
        Quadruple[] newTable = model.getLineItems();
        populateTable(newTable);
    }
    
//    public void addRentalItem(String itemIDString, int days){
//        if(days < 1){
//            ErrorScreen es = new ErrorScreen(days + " is not a valid number of rental days");
//        }
//        int test;
//    }
        
    public void addRentalItem(String itemIDString, String daysString){
        int id = -1;
        int days = 0;
        try{
           id = (Integer.parseInt(itemIDString));
           days = (Integer.parseInt(daysString));
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(itemIDString + " is not a number");
            return;
        }
        
        Quadruple balls = model.addItem(id, days);
        
        Quadruple[] newTable = model.getLineItems();
        populateTable(newTable);
    }
    
    public double getTotal(){
        return model.getTotal();
    }
    
    public double getSubTotal(){
       return model.getSubTotal();
    }
    
    public double getTax(){
        return model.getTax();
    }
    
    public void preCheckout(String total){
        model.preCheckout(userID, total);
    }
    
//    public void checkout() {
//		model.preCheckout(userID); //TODO: CHANGE THIS NOT TO ACCEPT A STRING ONCE USERS ARE IMPLEMENTED
//                
//		Create a new POS Contrller to wipe the screen - WARNING: THIS IS A TERRIBLE MEMORY LEAK RIGHT NOW
//		PurchaseSession newSession = new PurchaseSession(userID,password);
//		pos.setVisible(false);
		//PointOfSaleController newController = new PointOfSaleController(userID,password,newSession);
	//}
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
        pos.dispose();
        pos = new PointOfSaleUI(this);
        pos.setVisible(true);
        pos.setID(userID);
    }
    
}
