package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class PortifolioManagement extends BaseTest
{
	
  @Test
  public void createProtifolio() 
  {
	  System.out.println("createProtifolio");
	  test.log(Status.INFO, "createProtifolio");
	  
	  // report failure
	  app.reportFailure("test failed",false);
	  app.assertAll();
  }
  
  @Test
  public void modifyProtifolio() 
  {
	  System.out.println("modifyProtifolio");
  }
  
  @Test
  public void deleteProtifolio() 
  {
	  System.out.println("deleteProtifolio");
  }
}
