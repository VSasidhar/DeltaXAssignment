package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;


	public class Actions{
		 private static  Properties prop =new Properties();
			private static WebDriver driver =WebdriverFactory.getWebDriver();
			public static final SoftAssert softAssert = new SoftAssert();
		
		
	 
	public  static String getProperty(String property) {
		String value = null;
		 try {
			FileReader file=new FileReader("build.properties");
			prop.load(file);
			value = prop.getProperty(property);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;  
		
	}
	
	
	
	public static boolean IsVisible(ObjectLocator locator){
		
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	wait.until(ExpectedConditions.visibilityOf(FindElement(locator)));
	
		return FindElement(locator).isDisplayed();
	}

	public static WebElement FindElement(ObjectLocator locator) {
			
			WebElement webElement=null;

			try {
				WaitForWebElement(locator);
				webElement = driver.findElement(locator.Locator);
			} catch (org.openqa.selenium.NoSuchElementException ex) {
				// Handle exception if the element is not found		
				
				softAssert.fail("NoSuchElementException: The Object " + locator.locatorDescription + " not found! " + ex.getMessage());
				
			} 
			return webElement;
	}

	public static void  EnterText(ObjectLocator locator, String text){
		FindElement(locator).clear();
		FindElement(locator).sendKeys(text);
	
	}

	public static void  SelectbyVisibleText(ObjectLocator locator, String text){
		Select select = new Select(FindElement(locator));
		select.selectByVisibleText(text);
		
	}

	public static void WaitForWebElement(ObjectLocator locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		 wait.until(ExpectedConditions.elementToBeClickable(locator.Locator));
	
	}
		
	public static boolean IsDisplayed(ObjectLocator locator) {
		try {
			return FindElement(locator).isDisplayed();
			
		}catch(Exception e) {
			return false;
		}
	}
	
		
		public static void  Assertrue(boolean condition, String message){
			softAssert.assertTrue(condition, message); 
		}
		
		
		
}
