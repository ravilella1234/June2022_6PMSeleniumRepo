package com.launcher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2 
{

	public static void main(String[] args)
	{
		String month = "October 2022";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//div[@class='sc-jIZahH lbNpRy']/div/p[@class='sc-dIouRR gyRYav fswWidgetTitle']")).click();
		List<WebElement> months = driver.findElements(By.xpath("//div[@class='DayPicker-Month']/div[1]/div"));
		
		for(int i=0;i<months.size();i++)
		{
			if(!months.get(i).getText().contains(month))
			{
				
			}
		}

	}

}
