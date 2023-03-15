package com.generalstore.android.test;

import java.io.IOException;
import org.testng.annotations.Test;
import com.generalstore.Testutilities.AndroidBaseClass;
import com.generalstore.android.pages.ProductsPage;

public class AddProductsToCartTestCase extends AndroidBaseClass{
	
	

	@Test
	
	public void addProductsToCart() throws InterruptedException, IOException {
		ProductsPage productspage = new ProductsPage(driver);
		productspage.addItemToCartByIndex(0);
		
		productspage.clickCartButton();
		
		
		/*
		 * Thread.sleep(3000); boolean res = driver.getPageSource().contains("Cart");
		 * if(res==true) { Assert.assertTrue(true);
		 * 
		 * }else {
		 * 
		 * 
		 * Assert.assertTrue(false);
		 * 
		 * }
		 */
	}
}
