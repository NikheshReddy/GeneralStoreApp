package com.generalstore.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils  {

 public	AppiumDriver driver;
  public  Properties pro;
 public static	AppiumDriverLocalService service;

	
	public  AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
	 service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//User//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
	public Double getFormattedAmount(String amount) {
		
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
	}
	
	public String getScreenshotPath(AppiumDriver driver, String testCaseName)  throws IOException { 
		  
	  File source = driver.getScreenshotAs(OutputType.FILE); 
	  String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	  FileUtils.copyFile(source, new File(destinationFile)); 
	 
	  return destinationFile;
	  
	  }
	
	
	  public static String randomString() { 
		  String generatedstring = RandomStringUtils.randomAlphabetic(8); return(generatedstring); }
	 
	  public static String randomNum() { 
		  String generatedstring2 = RandomStringUtils.randomAlphanumeric(10); return(generatedstring2); }
	 }
