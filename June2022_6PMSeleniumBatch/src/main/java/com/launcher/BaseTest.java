package com.launcher;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	
	public static void init() throws Exception
	{
		System.out.println(projectPath);
		//FileInputStream fis = new FileInputStream("D:\\jan2022WD\\June2022_6PMSeleniumBatch\\src\\main\\resources\\data.properties");
		fis = new FileInputStream(projectPath+"\\src\\main\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
		//String e = p.getProperty("amazonurl");
		//System.out.println(e);
		
		fis = new FileInputStream(projectPath+"\\src\\main\\resources\\environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"\\src\\main\\resources\\"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("june2022FF");
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			//Handling Notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//How to work with proxy Settings
			//profile.setPreference("network.proxy.type", 1);
			//profile.setPreference("network.proxy.socks", "192.168.10.1");
			//profile.setPreference("network.proxy.socks_port", 1744);
			
			//Handling Certificate error
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
}
