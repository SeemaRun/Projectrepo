package com.comcast.ecommerce.genericfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		
		// TODO Auto-generated method stub
		 // Specify the properties file path
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		 // Get property value and return it
		String value  =pObj.getProperty(key);
		return value;

	}

}
