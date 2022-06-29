package com.launcher;

import org.apache.log4j.Logger;

public class TC_006 extends BaseTest
{

	private static final Logger log = Logger.getLogger(TC_006.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("init the properties files...");
		
		launch("chromebrowser");
		log.info("Opening Browser :" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigate to Url : " + childProp.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		selectOption("amazondropdown_id","Books");
		log.info("Selecting the option Books By using locator : " + orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Enter the text Harryn potter by using the locator :" + orProp.getProperty("amazonsearchtext_name") );
		
		clickElement("amazonsearchbutton_id");
		log.info("Click on Element By using locator : " + orProp.getProperty("amazonsearchbutton_id"));
				
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}

	

}
