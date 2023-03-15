package com.generalstore.android.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.generalstore.utilities.AndroidActions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{

	public AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id='com.androidsample.generalstore:id/rvCartProductList']")
	List<WebElement> productList;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']")
	WebElement totalAmount;
	@AndroidFindBy(xpath="//android.widget.CheckBox[@texxt='Send me e-mails on discounts related to selected products in future']")
	WebElement checkBox;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnProceed']")
	WebElement btnProceed;

	/*
	 * public void getProductList() { productList.get(0); }
	 */
	
	public void getTotalAmount() {
		
		System.out.println(totalAmount.getText());
		
	}

	public void clickProccedBtn() {
		btnProceed.click();
	}
	
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
}
