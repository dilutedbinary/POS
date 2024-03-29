package unittestpointofsalesystem;



import unittestpointofsalesystem.CreditCardJunit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CreditCardJunitRunner {
   public static void main(String[] args) {
	   System.out.println("Starting Junit Tests for CreditCard.java and CreditCardInterface.java");
      Result result = JUnitCore.runClasses(CreditCardJunit.class);
      for (Failure failure : result.getFailures()) {
         System.out.println("Failure in:"+failure.toString());
      }
      System.out.println("CreditCard Junit Test Results:"+result.wasSuccessful());
   }
}  
