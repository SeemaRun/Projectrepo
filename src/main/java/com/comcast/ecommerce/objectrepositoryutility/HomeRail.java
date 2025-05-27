package com.comcast.ecommerce.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.comcast.ecommerce.genericwebdriverutility.WebDriverUtility;

public class HomeRail extends WebDriverUtility {
	WebDriver driver;
	public HomeRail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtStationFrom")
	private WebElement fromtextfield;
	
	@FindBy(xpath="//div[text()='hi Azadpur']")
	private WebElement selectoption;
	
	@FindBy(xpath = "//div[@class='']")
    private List<WebElement> stationSuggestions;
	/**
	 * @return the fromtextfield
	 */
	public WebElement getFromtextfield() {
		return fromtextfield;
		
	}
 /**
	 * @return the selectoption
	 */
	public WebElement getSelectoption() {
		return selectoption;
	}
/**
 * @return the stationSuggestions
 */
public List<WebElement> getStationSuggestions() {
	return stationSuggestions;
}
public void enterStation(String name) {
	 waitForPageToLoad(driver);
	 driver.manage().window().maximize();
	 fromtextfield.click();
	 fromtextfield.clear();
	 fromtextfield.sendKeys(name);
	String fourname = selectoption.getText();
	
	 selectoption.click();
	 Reporter.log("fourth element  is : "  + fourname ,true );
	 
 }
	public void fromText(String name) {
		 waitForPageToLoad(driver);
		 driver.manage().window().maximize();
		 fromtextfield.click();
		 fromtextfield.clear();
		 fromtextfield.sendKeys(name);
	}

}
