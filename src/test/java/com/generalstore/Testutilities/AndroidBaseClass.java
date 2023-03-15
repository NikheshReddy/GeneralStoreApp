package com.generalstore.Testutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.generalstore.android.pages.HomePage;
import com.generalstore.utilities.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseClass extends AppiumUtils{

	public  AndroidDriver driver;
	public   AppiumDriverLocalService service;
	public   Properties pro;
 public	HomePage homePage;
	
	
	
	@BeforeClass(alwaysRun=true)
	public void ConfigurAppium() throws IOException, InterruptedException {
		
		
		File src = new File(System.getProperty("user.dir")+"//src//main//java//com//generalstore//resources//data.properties");
		
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		String ipAddress= pro.getProperty("ipAddress");
	    String port  = pro.getProperty("port");
	   
		
	    service = startAppiumServer(ipAddress, Integer.parseInt(port));
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(pro.getProperty("androidDeviceName"));
		Thread.sleep(1000);
		options.setApp(pro.getProperty("appPath"));
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	
		
		
		 
		
	}

	 @AfterClass(alwaysRun=true)
	 public void tearDown() { 
    driver.quit(); 
   service.stop();
   }
	

}
