package com.launcher;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) 
	{
		launch("chrome");
		
		navigateUrl("https://www.bestbuy.com");
	}

}
