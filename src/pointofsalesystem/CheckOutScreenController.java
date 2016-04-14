/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;


public class CheckOutScreenController {
    private int paymentType;
    private PurchaseSession ps;
    private CheckOutScreenUI coUI;
    private String tempID;
    double total;
    
    public CheckOutScreenController(PurchaseSession ps, String tempID, String total){
        this.tempID = tempID;
        this.ps = ps;
        coUI = new CheckOutScreenUI(this);
        coUI.setVisible(true);
        this.total = Double.parseDouble(total);
        
    }
    
    public boolean verifyCreditCard(String cardNumber){
            int test;
        try{
           test = (Integer.parseInt(cardNumber));
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(cardNumber + " is not a number");
        }
        //return ps.verifyCreditCard(test);
        return true;
    }
    
    public void getReceipt(){
        coUI.setVisible(false);
        AlertScreen al = new AlertScreen("Change due: $" + (coUI.getChange() - total) + "");
        al.setVisible(true);
        //ps.checkout(tempID);
        ps.checkout(tempID);
    }
    
    public double getChange(String cash){
            int test;
        try{
           test = (Integer.parseInt(cash));
        }catch(Exception ex){
            ErrorScreen es = new ErrorScreen(cash + " is not a number");
        }
        //return ps.getChange(test);
        return coUI.getChange();
    }
}
