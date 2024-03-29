package pointofsalesystem;
import java.io.Serializable;

public class Item implements Serializable {
    private int mID;
    private String mName;
    private int mTax_Type;
    private String mDescription;
    private double mPrice;
    private int mRentalPeriod;

    public Item(int mID, String mName, double mPrice, int mTax_Type, String mDescription, int mRentalPeriod){
	setID(mID);
	setName(mName);
	setTaxType(mTax_Type);
	setDescription(mDescription);
	setPrice(mPrice);
        setRentalPeriod(mRentalPeriod);
    }
    
    //non rental items dont have a rental period (can delete if we decide it is mandetory.
    public Item(int mID, String mName, double mPrice, int mTax_Type, String mDescription){
	setID(mID);
	setName(mName);
	setTaxType(mTax_Type);
	setDescription(mDescription);
	setPrice(mPrice);
    }
    public Item(Item i){
	if(i!=null){
	    setID(i.getID());
	    setName(i.getName());
	    setTaxType(i.getTaxType());
	    setDescription(i.getDescription());
	    setPrice(i.getPrice());
	}
    }
	
    public void setRentalPeriod(int mRentalPeriod){
        this.mRentalPeriod = mRentalPeriod;
    }
    public void setPrice(double mPrice){
	this.mPrice = mPrice;
    }

    public void setID(int mID){
	this.mID = mID;
    }
	
    public void setName(String mName){
	this.mName = mName;
    }
	
    public void setDescription(String mDescription){
	this.mDescription = mDescription;
    }
	
    public void setTaxType(int mTax_Type){
	this.mTax_Type = mTax_Type;
    }
	
    public int getRentalPeriod(){
        return this.mRentalPeriod;
    }
    public int getID(){
	return this.mID;
    }
	
    public String getName(){
	return this.mName;
    }
	
    public int getTaxType(){
	return this.mTax_Type;
    }
    
    public String getDescription(){
	return this.mDescription;
    }
    
    public double getPrice(){
	return this.mPrice;
    }
    
    public String toString(){
	return "Item " + mID + ": [Name: " + mName + ", Description: " + mDescription + ", TaxType: " + mTax_Type + ", Price: $" + mPrice + "]";
    }

    public boolean equals(Item i){

		//Note I am omitting price due to rounding errors and such
        return (this.mID == i.mID && this.mName.equals(i.mName) && this.mTax_Type == i.mTax_Type && this.mDescription.equals(i.mDescription));
    }
    public Item getCopy(){
	return new Item(this);
    }

}

