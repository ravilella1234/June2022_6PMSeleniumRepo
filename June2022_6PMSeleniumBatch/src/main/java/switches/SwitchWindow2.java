package switches;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow2 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		System.out.println(driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		while(!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@alt='FD'][@data-ll-status=\"loaded\"])[1]"))).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='card-nav slick-initialized slick-slider']/button[text()='Next']")).click();
		}
		driver.findElement(By.xpath("(//img[@alt='FD'][@data-ll-status=\"loaded\"])[1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> nwinds = new ArrayList<String>(windows);
		for(String i:nwinds)
		{
			System.out.println(i);
		}
		
		driver.switchTo().window(nwinds.get(1));
		System.out.println(driver.getTitle());
	}

}
