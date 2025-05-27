package com.comcast.ecommerce.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.ecommerce.genericwebdriverutility.WebDriverUtility;

public class CalenderPage extends WebDriverUtility {
	WebDriver driver;
	public  CalenderPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@title='Select Departure date for availability']")
	private WebElement dateTextfield;

}
