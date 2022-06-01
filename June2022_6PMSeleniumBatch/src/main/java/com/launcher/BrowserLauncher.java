package com.launcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\NewDrivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.in");
		
		WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver", "C:/Users/ravi/Desktop/NewDrivers/geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.bestbuy.com");
	}

}
