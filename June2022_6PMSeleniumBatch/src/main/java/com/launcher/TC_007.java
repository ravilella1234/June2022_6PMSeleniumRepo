package com.launcher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("sony");
		
		//Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
		
		//driver.findElement(By.linkText("Customer Service")).click();
		
		//WebElement loc = driver.findElement(By.partialLinkText("Customer Serv"));
		//loc.click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}
			
		}
		
		System.out.println("-------------------------------");
		
		List<WebElement> lnks = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		for(int i=0;i<lnks.size();i++)
		{
			System.out.println(lnks.get(i).getText());
		}

	}

}
