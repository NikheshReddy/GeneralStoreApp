package com.generalstore.Testutilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.BeforeClass;
import com.generalstore.utilities.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseClass extends AppiumUtils {
	
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;

	

	
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		
	    service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//User//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("33a38db60704");
		options.setApp("D://Selenium_WorkSpace//GeneralStore//src//test//java//General-Store.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.quit();
		service.stop();

}
}
