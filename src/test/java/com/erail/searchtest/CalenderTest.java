package com.erail.searchtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.ecommerce.generic.basetest.Baseclass;

public class CalenderTest extends Baseclass {
    
	@Test
	public void setDate()
	{
		int count=0;
		
		driver.get("https://erail.in/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
	
		WebElement currentdateweb = driver.findElement(By.xpath("//input[@title='Select Departure date for availability']"));
		String currentdate = (String)jse.executeScript("return arguments[0].value;", currentdateweb);
		System.out.println("Current Date : "+currentdate);
		
		for(;;)
		{
			driver.findElement(By.xpath("//a[@class='icon-right-big']")).click();
			count++;
			if(count==30)
			{
				break;
			}
			
		}
		
		
		WebElement actualdateweb = driver.findElement(By.xpath("//input[@title='Select Departure date for availability']"));
		String actualdate = (String)jse.executeScript("return arguments[0].value;", actualdateweb);
		System.out.println("Actual Date is "+actualdate);
		
	
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yy EEE");
		String ndate = sim.format(date);
		System.out.println(ndate);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String curdate = sim.format(cal.getTime());
		
		System.out.println(curdate);
	
		Assert.assertEquals(actualdate, curdate);
		
	}
	
	
	

		
	}

