/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;


public class MakeCustomerController {

    private String userID;
    private String userPassword;
    public MakeCustomerUI mcUI;
    
    public MakeCustomerController(){
            //mcUI = new MakeCustomerUI(this);
            //mcUI.run();
    }
    
    public String getUserID(){
        return userID;
    }
    
    public String getUserPassword(){
        return userPassword;
    }
}
