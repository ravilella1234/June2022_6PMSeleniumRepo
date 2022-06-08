package com.launcher;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{

		init();
		
		launch("firefoxbrowser");
		
		navigateUrl("cerificateurl");
		
		driver.manage().window().maximize();
	}

}
