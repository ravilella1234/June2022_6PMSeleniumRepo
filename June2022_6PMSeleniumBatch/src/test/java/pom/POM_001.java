package pom;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class POM_001 extends BaseTest
{
	
  LoginPage page;
  CustomerRegistrationPage cp;
	  
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	    init();
		test = rep.createTest("TNG_003");
		test.log(Status.INFO, "init the properties files...");
		
		launch(bType);
		test.log(Status.INFO, "Opening Browser :" + p.getProperty("chromebrowser"));
		
		navigateUrl("auomationurl");
		test.log(Status.INFO, "Navigate to Url : " + childProp.getProperty("auomationurl"));
		
		driver.manage().window().maximize();
	  
  }

  @Test(enabled = false)
  public void loginTest() 
  {
	  page = new LoginPage(driver);
	  page.login();
	  Assert.assertEquals(page.getLoginError(), "Authentication failed.");
  }
  
  @Test
  public void custReg() throws Exception
  {
	  cp = new CustomerRegistrationPage(driver);
	  cp.customerRegistration();
  }
  
  @AfterMethod
  public void endProcess() 
  {
	  
  }

}
