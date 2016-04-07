/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

/**
 *
 * @author ems316
 */
import rentalcalculator.RentalCalculator;

public class RentalCalculatorInterface {

    public RentalCalculatorInterface(){}
    
    public double calculateCost(Item i){ 
        RentalCalculator Calc = new RentalCalculator();
        Calc.enterRentalInfo(i.getRentalPeriod(), i.getPrice());
        return Calc.CalculateRentalTotal();
    }
}
