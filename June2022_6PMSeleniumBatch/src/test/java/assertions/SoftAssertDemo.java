package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SoftAssertDemo extends BaseTest
{
	public SoftAssert soft;
  
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
  public void f() 
  {
	  String actualTilte = driver.getTitle();
	  String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.i";
		
		soft = new SoftAssert();
		//soft.assertEquals(actualTilte, expectedTitle);
		soft.assertTrue(actualTilte.equals(expectedTitle), "Both titles are not equal...");
		
		soft.assertTrue(false, "err1");
		
		soft.assertTrue(false, "err2");
		
		soft.assertTrue(true, "err3");
		
		soft.assertTrue(false, "err4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		
		 soft.assertAll();
  }

  @AfterMethod
  public void afterMethod()
  {
	 
  }

}
