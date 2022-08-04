package testbase;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import keywords.ApplicationKeywords;

public class BaseTest 
{
	public ApplicationKeywords app;
 
  @BeforeTest
  public void beforeTest(ITestContext context)
  {
	  System.out.println("beforeTest");
	  app = new ApplicationKeywords();
	  context.setAttribute("app", app);
  }

  
  @BeforeMethod
  public void beforeMethod(ITestContext context)
  {
	 app=  (ApplicationKeywords)context.getAttribute("app");
  }
  
  @AfterTest
  public void afterTest()
  {
	  System.out.println("afterTest");
  }

}
