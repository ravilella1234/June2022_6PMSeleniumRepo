package testbase;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest 
{
	public ApplicationKeywords app;
	public ExtentReports rep;
	public ExtentTest test;
 
  @BeforeTest
  public void beforeTest(ITestContext context) throws Exception
  {
	  System.out.println("beforeTest");
	  app = new ApplicationKeywords();
	  context.setAttribute("app", app);
	  
	  //init the reporting for the test
	  rep = ExtentManager.getReports();
	  test = rep.createTest(context.getCurrentXmlTest().getName());
	  app.setReport(test);
	  context.setAttribute("report", rep);
	  context.setAttribute("test", test);
  }

  
  @BeforeMethod
  public void beforeMethod(ITestContext context)
  {
	 app=  (ApplicationKeywords)context.getAttribute("app");
	 
	 rep = (ExtentReports)context.getAttribute("report");
	 test = (ExtentTest)context.getAttribute("test");
  }
  
  @AfterTest
  public void quit()
  {
	  if(rep!=null)
		  rep.flush();
  }
  
}
