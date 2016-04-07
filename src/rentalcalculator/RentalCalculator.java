/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalcalculator;

/**
 *
 * @author Ryan
 */
public class RentalCalculator {
    private double rental_rate;
    private int rental_period;
    private double item_cost;
    
    
    public RentalCalculator(){
		//do nothing
    } 
    
    public void enterRentalInfo(int rental_period, double item_cost) {
        this.rental_period = rental_period;
        this.item_cost = item_cost;
    }
     
    public double CalculateRentalTotal() {
        return (item_cost*.25) + (.10 * rental_period);
    }
}
