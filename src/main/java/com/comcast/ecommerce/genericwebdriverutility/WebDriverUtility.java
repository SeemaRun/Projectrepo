package com.comcast.ecommerce.genericwebdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//Method for implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
  //method for Explicitly wait
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//Create method for Switch to window using foreach loop ,childwindow
	public void switchtoTabOnURL(WebDriver driver ,String partialURL) {
		Set<String> windowhandles = driver.getWindowHandles();
		for(String windowID :windowhandles) {
			driver.switchTo().window(windowID);
			String actURL =driver.getCurrentUrl();
			if(actURL.contains(partialURL)) {
				break;
			}
			}
		
	}
	//return to dashboard
	
}
