package com.comcast.ecommerce.generic.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.ecommerce.genericfileutility.ExcelUtility;
import com.comcast.ecommerce.genericfileutility.Fileutility;
import com.comcast.ecommerce.genericwebdriverutility.Javautility;
import com.comcast.ecommerce.genericwebdriverutility.WebDriverUtility;

public class Baseclass {
	
	public Fileutility  flib = new Fileutility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility(); 
	public Javautility jlib = new Javautility();
	// Instance variable: Each test class gets its own driver instance
	public WebDriver driver = null;

	// Static variable: Shared across the framework, useful for utilities (e.g., screenshots,listeners)
	public static WebDriver sdriver = null;
	
	@BeforeSuite
	public void configBS() {
		System.out.println("== connect to DB,REPORT config===");
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("==Launch the browser");
		String Browser =flib.getDataFromPropertiesFile("browser");
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(Browser.equals("firefox"))
				{
				driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("==login==");
		
	}
	
	@AfterMethod
	public void configAM( ) {
		System.out.println("==logout==");
	}
	@AfterClass
	public void configAC() {
		System.out.println("==close the browsers==");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("==close the Db connection");
	}
	
}
