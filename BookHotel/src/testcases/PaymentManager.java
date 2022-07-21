package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager 
{
  @Test
  public void applyDiscount() 
  {
	  System.out.println("-------  applyDiscount  -------");
  }
  
  @Parameters({"action"})
  @Test
  public void makePayment(String parameterType, ITestContext context) 
  {
	 // System.out.println("-------  makePayment  -------");
	  
	  if(parameterType.equals("ElectonicMedia"))
		  System.out.println("MakePayment through ElectonicMedia");
	  else
		  System.out.println("MakePayment through Pay@Hotel");
	  
	  // Booking ID
	  String bookingID =  "RRR2346";
	  System.out.println("Booking ID : " + bookingID);
	  context.setAttribute("bID", bookingID);
  }
}
