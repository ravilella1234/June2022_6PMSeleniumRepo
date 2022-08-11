package testbase;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;


// acceptable Failure,  critical Failure, Unexpected Failure

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
	 
	 String criticalFailure = (String)context.getAttribute("criticalFailure");
	  if(criticalFailure!=null && criticalFailure.equals("Y"))
	  {
		  test.log(Status.SKIP, "Critical Failure in previous Test");
		  throw new SkipException("Critical Failure in previous Test"); 
	  }
	 
  }
  
  @AfterTest
  public void quit()
  {
	  if(rep!=null)
		  rep.flush();
  }
  
}
