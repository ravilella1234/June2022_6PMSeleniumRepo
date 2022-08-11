package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class Session extends BaseTest
{
  @Test
  public void doLogin() 
  {
	  test.log(Status.INFO, "Logging In.....");
	  app.openBrowser("chromebrowser");
	  app.navigate("rediffurl");
	  app.click("signin_xpath");
	  app.type("useremail_id","rediffuser");
	  //report failure
	  app.reportFailure("Test is incorrect...",true);
	  app.type("userpassword_id","rediffpassword");
	  app.click("submit_id");
	  app.assertAll();
  }
  
  @Test
  public void doLogout() 
  {
	  test.log(Status.INFO, "Logging Out ....");
	  System.out.println("doLogout");
  }
}
