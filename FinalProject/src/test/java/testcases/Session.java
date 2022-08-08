package testcases;

import org.testng.annotations.Test;

import testbase.BaseTest;

public class Session extends BaseTest
{
  @Test
  public void doLogin() 
  {
	  System.out.println("doLogin");
	  app.openBrowser("chromebrowser");
	  app.navigate("rediffurl");
	  app.click("signin_xpath");
	  app.type("useremail_id","rediffuser");
	  app.type("userpassword_id","rediffpassword");
	  app.click("submit_id");
  }
  
  @Test
  public void doLogout() 
  {
	  System.out.println("doLogout");
  }
}
