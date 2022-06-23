package switches;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlert 
{

	public static void main(String[] args) 
	{
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize(); 
		  //https://sreedharscce.com/
		  driver.navigate().to("http://demo.guru99.com/selenium/delete_customer.php");
		  
		  driver.findElement(By.name("cusid")).sendKeys("23232");
		  driver.findElement(By.name("submit")).click();
		  Alert al = driver.switchTo().alert();
		  System.out.println(al.getText());
		  al.accept();
		  

	}

}
