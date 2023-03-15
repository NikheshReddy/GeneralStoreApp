package com.generalstore.android.test;

import org.testng.annotations.Test;
import com.generalstore.Testutilities.AndroidBaseClass;
import com.generalstore.android.pages.HomePage;

public class LaunchAppTestCase extends AndroidBaseClass{
	
	HomePage homepage;

	@Test
     public  void AppLuncher() throws InterruptedException   {

   Thread.sleep(1000);
		homePage = new HomePage(driver);
    	 homePage.enterName(pro.getProperty("name"));
    	 homePage.selectGender(pro.getProperty("gender"));
    	 homePage.selectCountry(pro.getProperty("countryname"));
    	 homePage.clickBtnLetsShop();
	}
	
	/*
	 * @BeforeMethod public void preSetup() {
	 * 
	 * homePage.setActivity();
	 * 
	 * }
	 */
    	 
			/*
			 * Thread.sleep(3000); boolean res =
			 * driver.getPageSource().contains("Products"); if(res==true) {
			 * Assert.assertTrue(true);
			 * 
			 * }else {
			 * 
			 * captureScreen(driver,"loginTest"); Assert.assertTrue(false);
			 * 
			 * }
			 */
  
     

	
		/*
		 * @BeforeMethod public void preSetup() { Activity activity = new
		 * Activity("com.androidsample.generalstore",
		 * "com.androidsample.generalstore.MainActivity");
		 * 
		 * ((StartsActivity) driver).startActivity(activity);
		 * 
		 * }
		 */
		/*
		 * @DataProvider public Object[][] getData() throws IOException{
		 * 
		 * List<HashMap<String, String>> data =
		 * getJsonData(System.getProperty("user.dir")+
		 * "src//test//java//com//generalstore//TestData//testData.jason"); return new
		 * Object[][] {{data.get(0)},{data.get(1)}} ;
		 * 
		 * }
		 */
}

