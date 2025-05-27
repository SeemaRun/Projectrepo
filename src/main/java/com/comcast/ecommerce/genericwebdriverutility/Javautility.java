package com.comcast.ecommerce.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
  
	//method for random number
	public int getRandomNumber() {
	Random random = new Random();
	  int randomNum = random.nextInt(1000);
	  return randomNum;
}
	//method for start date format
	public String getSystemDateYYDDMM() {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date =sdf.format(dateobj);
		return date;
	}
	//create method for end date format or REquired date(next,or previous)
	public String getRequiredDateYYDDMM(int days) {
		Date dateobj = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat();
			String date =	sdf.format(dateobj);
			Calendar cal =sdf.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,days);
			String reqDate =sdf.format(cal.getTime());
			return reqDate;
				
	}
}
