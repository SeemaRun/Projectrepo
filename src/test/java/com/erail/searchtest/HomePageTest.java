package com.erail.searchtest;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.ecommerce.generic.basetest.Baseclass;
import com.comcast.ecommerce.genericfileutility.ExcelUtility;
import com.comcast.ecommerce.objectrepositoryutility.HomeRail;

public class HomePageTest extends Baseclass {

    @Test
    public void getHomePage() throws IOException {
        String stationName = flib.getDataFromPropertiesFile("stationname");
        String expectedName = flib.getDataFromPropertiesFile("expectname");

        HomeRail hr = new HomeRail(driver);
        hr.enterStation(stationName);

        // String selectedStation = hr.getSelectoption().getText();
        // Reporter.log(selectedStation, true);
    }

    @Test
    public void compareWithExistingStation() throws IOException {
        String stationName = flib.getDataFromPropertiesFile("stationname");
        String expectedName = flib.getDataFromPropertiesFile("expectname");

        HomeRail hr = new HomeRail(driver);
        hr.fromText(stationName);

        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@title]"));
     int rowcount = 1;
        for (WebElement station : suggestions) {
            String stationText = station.getText();
            Reporter.log(stationText, true);
        
        ExcelUtility sde = new ExcelUtility();
        sde.setDataIntoExcel("Expectedstaion", rowcount, 1, stationText);
        rowcount++;
        }
    }
}
