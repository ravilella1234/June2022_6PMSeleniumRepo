package keywords;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords
{
	public WebDriver driver;
	public String projectPath = System.getProperty("user.dir");
	public FileInputStream fis;
	public Properties mainProp;
	public Properties childProp;
	public Properties orProp;
	
	public void openBrowser(String browserName)
	{
		System.out.println("Opening Browser : "+ childProp.getProperty(browserName));
		if(childProp.getProperty(browserName).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(childProp.getProperty(browserName).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void navigate(String url)
	{
		System.out.println("Navigating to URL : " + childProp.getProperty(url));
		driver.get(childProp.getProperty(url));
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String textKey)
	{
		getElement(locatorKey).sendKeys(childProp.getProperty(textKey));
	}
	
	public void selectOption(String locatorKey, String optionKey)
	{
		getElement(locatorKey).sendKeys(childProp.getProperty(optionKey));
	}
	
	public void getText()
	{
		
	}
	
	
	public WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for Element Present
		if(!isElementPresent(locatorKey))
			//report failure
			System.out.println("Element is Not present : " + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		
		
		return element;
	}

	public  boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element presence :" + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	
	public  By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}

}
