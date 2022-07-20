package assertions;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HardAssert extends BaseTest
{
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception 
  {
	  System.out.println("Stating BeforeMethod");
	    init();
		test = rep.createTest("HardAssertion");
		test.log(Status.INFO, "init the properties files...");
		
		launch(bType);
		test.log(Status.INFO, "Opening Browser :" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigate to Url : " + childProp.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
  }
  
  
  @Test
  public void f() throws Exception 
  {
		String actualTilte = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.i";
		
		//Assert.assertEquals(actualTilte, expectedTitle);
		Assert.assertTrue(actualTilte.equals(expectedTitle));
		
		driver.findElement(By.linkText("Customer Service")).click();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
