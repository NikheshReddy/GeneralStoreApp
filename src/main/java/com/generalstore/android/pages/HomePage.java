package com.generalstore.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.generalstore.utilities.AndroidActions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomePage extends AndroidActions {
	

	  AndroidDriver driver;

	public HomePage(AndroidDriver driver) {

		super(driver);
		this.driver =driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
	WebElement enterName;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")
	WebElement radioFemale;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")
	WebElement radioMale;
	@AndroidFindBy(id = "android:id/text1")
	WebElement selectCountry;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
	WebElement btnLetsShop;


	public void enterName(String name) {
		enterName.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	public void selectGender(String gender) {
		if(gender.contains("Female"))
			radioFemale.click();
		else
			radioMale.click();
		}
	
	public void selectCountry(String countryname) {
		selectCountry.click();
		scrollToText(countryname);
	driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryname+"']")).click();
	}
	
	public void clickBtnLetsShop() {
		btnLetsShop.click();
	}
	
	
	  
	 
	
	
}
