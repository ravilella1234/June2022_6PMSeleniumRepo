package com.launcher;

import com.aventstack.extentreports.Status;

public class TC_008 extends BaseTest
{

		
	public static void main(String[] args) throws Exception 
	{
		init();
		test = rep.createTest("TC_008");
		test.log(Status.INFO, "init the properties files...");
		
		launch("chromebrowser");
		test.log(Status.INFO, "Opening Browser :" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigate to Url : " + childProp.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		selectOption("amazondropdown_id","Books");
		test.log(Status.PASS, "Selecting the option Books By using locator : " + orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Enter the text Harryn potter by using the locator :" + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_id");
		test.log(Status.INFO, "Click on Element By using locator : " + orProp.getProperty("amazonsearchbutton_id"));
				
		rep.flush();
	}

	

}
