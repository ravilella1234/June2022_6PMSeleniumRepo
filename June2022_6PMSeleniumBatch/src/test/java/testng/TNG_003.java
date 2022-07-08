package testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_003 extends BaseTest
{
  
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  System.out.println("Stating BeforeMethod");
	    init();
		test = rep.createTest("TNG_003");
		test.log(Status.INFO, "init the properties files...");
		
		launch(bType);
		test.log(Status.INFO, "Opening Browser :" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigate to Url : " + childProp.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		
  }
  
  @Test
  public void amazonTest() 
  {
	  System.out.println("Stating amazonTest");
	    selectOption("amazondropdown_id","Books");
		test.log(Status.PASS, "Selecting the option Books By using locator : " + orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Enter the text Harryn potter by using the locator :" + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_id");
		test.log(Status.INFO, "Click on Element By using locator : " + orProp.getProperty("amazonsearchbutton_id"));
  }

  @AfterMethod
  public void endProcess() 
  {
	  System.out.println("Ending AfterMethod");
	  rep.flush();
	  driver.quit();
  }

}
