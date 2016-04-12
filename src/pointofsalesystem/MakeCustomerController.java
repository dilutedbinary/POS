/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;


public class MakeCustomerController {

    private String userID;
    private String userPassword;
    private PurchaseSession ps;
    public MakeCustomerUI mcUI;
    
    
    public MakeCustomerController(PurchaseSession ps){
            this.ps = ps;
            mcUI = new MakeCustomerUI(this);
            mcUI.run();
    }
    
    public void AddUserID(){
        ps.AddUID(userID);
    }
    
    public void AddUserPassword(){
        return ps.AddUP(userPassword);
    }
}
