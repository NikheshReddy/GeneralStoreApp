package com.generalstore.android.test;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.generalstore.Testutilities.AndroidBaseClass;
import com.generalstore.android.pages.HomePage;

import io.appium.java_client.android.Activity;

public class SmokeTestCase extends AndroidBaseClass {
	
	@BeforeMethod
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}

	@Test(groups= {"Smoke"})
	public void fillForm_ErrorValidation() {
		homePage = new HomePage(driver);
		 homePage.selectCountry(pro.getProperty("countryname"));
		 homePage.selectGender(pro.getProperty("gender"));
		 homePage.clickBtnLetsShop();
	
			 String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"); 
			 AssertJUnit.assertEquals(toastMessage,"Please your name");
			
	}
     
	
	@Test(groups= {"Smoke"})
	public void fillForm_PositiveFlow() {
		homePage = new HomePage(driver);
   	 homePage.selectCountry(pro.getProperty("countryname"));
   	 homePage.enterName(pro.getProperty("name"));
   	 homePage.selectGender(pro.getProperty("gender"));
   	 homePage.clickBtnLetsShop();
	}
	
	}



