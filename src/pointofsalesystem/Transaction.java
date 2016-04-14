package pointofsalesystem;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.io.Serializable;

public class Transaction implements Serializable{
    private int mTransactionID;
    private User mCustomer;
    private User mCashier;
    private int mTransactionType;
    private ArrayList<Quadruple<Item, Integer, Integer, Integer>> mQuadrupleList;
    private int mPaymentMethod;
    private Timestamp mTimestamp;
    //private double mSubTotal = 0.0;
    //private double mTotal = 0.0;

    public static final int SALE = 0;
    public static final int RENTAL = 1;
    public static final int RETURN = 2;
    public static final int CASH = 0;
    public static final int CREDIT = 1;
    public static final int DEBIT = 2;
    public static final int GIFTCARD = 3;

	public Transaction(User mCustomer, User mCashier) {
		System.out.println("Beginning of trans constructor");
                setCustomer(mCustomer);
		setCashier(mCashier);
		setTransactionID(0);   //default transactionID
                mQuadrupleList = null;
                System.out.println("is called");
	}
	
    public Transaction(int mTransactionID, User mCustomer, User mCashier){
		
	setTransactionID(mTransactionID);
	setCustomer(mCustomer);
	setCashier(mCashier);
	setTransactionType(mTransactionType);
        mQuadrupleList = null;
	
    }
    
    public void setTransactionID(int mTransactionID){
	this.mTransactionID = mTransactionID;
    }
    
    public void setCustomer(User mCustomer){
	this.mCustomer = mCustomer;
    }
    
    public void setCashier(User mCashier){
	this.mCashier = mCashier;
    }
        
    public void setTransactionType(int mTransactionType){
	this.mTransactionType = mTransactionType;
    }
    
   public void setTimestamp(Timestamp timestamp) {
	this.mTimestamp = timestamp;
   }
   
   public Timestamp getTimestamp() {
	return mTimestamp;
  }

    public int getTransactionID(){
	return this.mTransactionID;
    }
    
    public User getCustomer(){
	return this.mCustomer;
    }
    
    public User getCashier(){
	return this.mCashier;
    }
    
    public ArrayList<Quadruple<Item, Integer, Integer, Integer>> getQuadrupleList(){
	return this.mQuadrupleList;
	}
    
    public int getTransactionType(){
	return this.mTransactionType;
    }
    
    public int getPaymentMethod(){
	return this.mPaymentMethod;
    }
    
    public double getTax(){
	Tax_Calc_Interface Calc = new Tax_Calc_Interface();
	return round(Calc.calculateTax(this));
    }
    //TODO: insert item into arraylist
    public void addItem(Quadruple<Item, Integer, Integer, Integer> t){
        boolean dup_flag = false;
        if(mQuadrupleList == null){
            mQuadrupleList = new ArrayList<Quadruple<Item,Integer, Integer, Integer>>();
        }
        for(int i=0; i < mQuadrupleList.size(); i++) {
            if((mQuadrupleList.get(i).getA().getID() == t.getA().getID()) && (mQuadrupleList.get(i).getC().equals(t.getC())) && (mQuadrupleList.get(i).getD() <= 0)) {
                mQuadrupleList.get(i).setB(new Integer((mQuadrupleList.get(i).getB().intValue()) + 1));
                dup_flag = true;
            }
        }
        if(!dup_flag) {
            if (t.getD() > 0){
                RentalCalculatorInterface r = new RentalCalculatorInterface();
                t.getA().setPrice(r.calculateCost(t.getD().intValue(),t.getA().getPrice()));
            }
            mQuadrupleList.add(t);
        }
    }
    
    //TODO: remove item from list
    public void removeItem(Quadruple<Item, Integer, Integer, Integer> t){
	for(int i =0; i < mQuadrupleList.size(); i++){
	    if(t.getA().getID() == mQuadrupleList.get(i).getA().getID()){
	    	mQuadrupleList.remove(t);
	    }
	}
    }
    public void addPayment(int mPaymentMethod){
	this.mPaymentMethod = mPaymentMethod;
    }
    public double calculateSubTotal(){
	double mSubTotal = 0.0;
	for(int i = 0; i < getQuadrupleList().size(); i++){
	    mSubTotal += getQuadrupleList().get(i).getA().getPrice() * getQuadrupleList().get(i).getB();
	}
	return round(mSubTotal);
    }
    public double calculateTotal(){
		double mTotal = 0.0;
		
    	return mTotal = round(this.calculateSubTotal() + this.getTax());
    }
    
    //Rounds a double to two decimal places
    private double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
    
    public String toString(String myid){
    	StringBuilder s = new StringBuilder();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
    	s.append("$crumDogBillionairesPOS\n\n");
    	s.append(dateFormat.format(date) + "\n\n");
   		s.append("\tName\t|\tPrice\t|\tQty\t|\tType\t|\tRental Period(Days)\t\n");
    	for(int i = 0; i < mQuadrupleList.size(); i++){
    		s.append("\n\t" + mQuadrupleList.get(i).getA().getName() + "\t\t" + mQuadrupleList.get(i).getA().getPrice() 
    				+ "\t\tx" + Integer.toString(mQuadrupleList.get(i).getB()));
                
                switch(mQuadrupleList.get(i).getC()) {
                    case -1:
                        s.append("\t\t RETURN\t");
                        s.append("\t\t N/A\t");
                        break;
                    case 0:
                        s.append("\t\t SALE\t");
                        s.append("\t\t N/A\t");
                        break;
                    case 1:
                        s.append("\t\t RENTAL\t");
                        s.append("\t\t "+ mQuadrupleList.get(i).getA().getRentalPeriod()+ "\t");
                        break;
                    default:
                        break;
                }
                           
        }
    	s.append("\n\nSubTotal: $" + Double.toString(calculateSubTotal()) + "\nTax: $" + Double.toString(getTax()) 
    				+ "\nTotal: $" + Double.toString(calculateTotal()) + "\n\n");
    	
    	s.append("Cashier:" + myid + "\n\n");
        s.append("Rental rules: rental price for the period given is equal to $(itemprice * .25) + (rentalperiod *.10)");
    	s.append("HAVE  A GREAT DAY!");
    	return s.toString();
    }
    
    public String deprecatedtoString(String myid){
    	StringBuilder s = new StringBuilder();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
    	s.append("$crumDogBillionairesPOS\n\n");
    	s.append(dateFormat.format(date) + "\n\n");
   		s.append("Name | Price | Qty |\n");
    	for(int i = 0; i < mQuadrupleList.size(); i++){
    		s.append("\n" + mQuadrupleList.get(i).getA().getName() + " " + mQuadrupleList.get(i).getA().getPrice() 
    				+ "  x" + Integer.toString(mQuadrupleList.get(i).getB()));
    	}
    	s.append("\n\nSubTotal: $" + Double.toString(calculateSubTotal()) + "\nTax: $" + Double.toString(getTax()) 
    				+ "\nTotal: $" + Double.toString(calculateTotal()) + "\n\n");
    	
    	s.append("Cashier:" + myid + "\n\n");
    	s.append("HAVE  A GREAT DAY!");
    	return s.toString();
    }
 
}
