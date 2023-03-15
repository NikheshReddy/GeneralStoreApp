package com.generalstore.android.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.generalstore.utilities.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage extends AndroidActions {
	
	public AndroidDriver driver;
	
	
	public ProductsPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	List<WebElement> addToCart;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
	WebElement btnCart;
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	
	public void clickCartButton() {
		btnCart.click();
	}

	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
}
