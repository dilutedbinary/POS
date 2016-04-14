package pointofsalesystem;

public class ManagerController {
    private ManagerSessionUI MsUI;
    private AddNewProductUI anpUI;
    private UpdateProductUI upUI;
    
    //Now create a manager session object
    private boolean newProduct;

    public ManagerController(){
        MsUI = new ManagerSessionUI(this);
        MsUI.run();
    }
    
    public void newProduct(){
        AddNewProductUI np = new AddNewProductUI(this);
        np.setVisible(true);
        anpUI = np;
    }
    
    public void addNewProduct(String Name, String idString, String qtString, String ppuString, String taxIDString){
        //validate and pass to session to be added to the database
        Integer temp;
        int id, quantity, taxID;
        if((temp = validateStringtoNumber(idString)) != null){
            id = temp;
        }else{
            error("invalid ID #");
            return;
        }
        
        System.out.println("Added New Product");
        return;
    }
    
    //null is a failed attempt
    private Integer validateStringtoNumber(String input){
        Integer output = Integer.getInteger(input);
        return output;
    }
    
    private void error(String message){
        ErrorScreen es = new ErrorScreen(message);
        es.setVisible(true);
    }
    
    public void updateProduct(String idString){
        //validate product id
        //int id = Integer.getInteger(idString);
        //pass id to manager session to get product information
        
//        System.out.println("balls");
        //MsUI.spawnUpdateProductWindow();
        UpdateProductUI up = new UpdateProductUI(this);
        up.setVisible(true);
        upUI = up;
    }
    
    // balls balls balls
    public void createCashier(String name,String phone,String mobile,String email,String ship_add_line1,String ship_add_line2,String ship_add_city,String ship_add_state,String ship_add_zip,String cred_name,String cred_number,String cred_month,String cred_year,String cred_cvc,String username,String password1,String password2){
        //call method in session to add to database and return ID number
       if(!password1.equals(password2)){
         String message = "Error: Passwords don't match!!!!!";
            AlertScreen al = new AlertScreen(message);
        al.setVisible(true);
        }
        //The number 2 is for create cashier
        PurchaseSession model = new PurchaseSession("jfc216","abc123");
        int id = model.addNewUser(2,name, phone, mobile, email, ship_add_line1,ship_add_line2,ship_add_city,ship_add_state,ship_add_zip,cred_name,cred_number,cred_month,cred_year,cred_cvc, username, password1);
         if(id == -10) {
         String message = "Error: Credit Card Entered is not valid!!!";
            AlertScreen al = new AlertScreen(message);
        al.setVisible(true);
        } 
         else if(id < 0) {
         String message = "Error: Unable to create new user!!!";
            AlertScreen al = new AlertScreen(message);
        al.setVisible(true);
        }
        else {
        String message = "New Customer created with id#: "+id;
        AlertScreen al = new AlertScreen(message);
        al.setVisible(true);
        }
    }
    
    
}
