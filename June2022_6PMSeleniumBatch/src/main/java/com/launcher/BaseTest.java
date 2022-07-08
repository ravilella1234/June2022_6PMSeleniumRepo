package com.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports rep;
	public static ExtentTest test;
	
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
		
		fis = new FileInputStream(projectPath+"\\src\\main\\resources\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectPath+"\\src\\main\\resources\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep = ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\ravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 16");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			//option.addArguments("--proxy-server=https://192.168.10.1:9090");
			//option.addArguments("--ignore-certificate-errors-spki-list");
			
			
			driver = new ChromeDriver(option);
		}
		else if(browser.equals("firefox")) 
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
		
		driver.manage().timeouts().getPageLoadTimeout();
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(locator)).click();
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text)
	{
		//driver.findElement(By.name(locator)).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(locator)).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for Element Present
		if(!isElementPresent(locatorKey))
			//report failure
			System.out.println("Element is Not present : " + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}*/
		
		return element;
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element presence :" + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*if(locatorKey.endsWith("_id")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_classname")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_css")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_linktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_partiallinktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
			}*/
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.name(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
	
	//verifications
	public static boolean isLinkEqual(String expectedLink) 
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	// Reportings
	
	public static void logInfo(String info) 
	{
		test.log(Status.INFO, info);
	}
	
	public static void reportSuccess(String passMsg) 
	{
		test.log(Status.PASS, passMsg);
	}

	public static void reportFailure(String failMsg) throws Exception 
	{
		test.log(Status.FAIL, failMsg);
		takesScreenshot();
	}

	public static void takesScreenshot() throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectPath+"//failurescreenshots//"+dateFormat));
		
		logInfo("Screenshot --->" +test.addScreenCaptureFromPath(projectPath+"//failurescreenshots//"+dateFormat));
	}

	
	
	
}
