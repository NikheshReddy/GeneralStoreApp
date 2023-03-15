package com.generalstore.android.test;

import org.testng.annotations.Test;
import com.generalstore.Testutilities.AndroidBaseClass;
import com.generalstore.android.pages.CartPage;


public class CartPageTestCase extends AndroidBaseClass {
	
	@Test
	public void cartPageTestCase() throws InterruptedException {
		
		CartPage cartpage = new CartPage(driver);
		cartpage.getTotalAmount();
		cartpage.clickProccedBtn();	
	}
	
	

}
