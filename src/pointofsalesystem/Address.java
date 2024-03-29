package pointofsalesystem;
import java.io.Serializable;
/** Class that represents a customer address. */
public class Address implements Serializable {
  
  private String mLine1;
  private String mLine2;
  private String mCity;
  private String mState;
  private String mZip;
  
  /** Constructor which creates a Address object. */
  public Address(String line1, String line2, String city,String state, String zip) {
    mLine1 = line1;
    mLine2 = line2;
    mCity = city;
    mZip = zip;
    mState = state;
  }
  
  /** Gets line1. */
  public String getLine1() {
    return mLine1;
  }
  
  /** Sets line1. */
  public void setLine1(String line1) {
    mLine1 = line1;
  }
  
  /** Gets line2. */
  public String getLine2() {
    return mLine2;
  }
  
  /** Sets line2. */
  public void setLine2(String line2) {
    mLine2 = line2;
  }
  
  /** Gets city. */
  public String getCity() {
    return mCity;
  }
  
  /** Sets city. */
  public void setCity(String city) {
    mCity = city;
  }
  
  /** Gets zip. */
  public String getZip() {
    return mZip;
  }
  
  /** Sets zip. */
  public void setZip(String zip) {
    mZip = zip;
  }
  
   /** Gets state. */
  public String getState() {
    return mState;
  }
  
  /** Sets state. */
  public void setState(String state) {
    mState = state;
  }
}