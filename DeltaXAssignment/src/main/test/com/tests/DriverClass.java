package com.tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pages.RegistrationPage;
import com.utils.Actions;
import com.utils.ExcelReader;
import com.utils.WebdriverFactory;

public class DriverClass{
	RegistrationPage registr;
	 static WebDriver driver;
	@Parameters({"browserName"})
	@BeforeTest
	public void testInit(String browserName) throws InterruptedException{
		driver= WebdriverFactory.intialiseWebDriver(browserName);
		 registr = PageFactory.initElements(driver, RegistrationPage.class);
	}
	
	@DataProvider(name="iterator")
	public Object[][] getTestData() throws IOException{
		return ExcelReader.readExcelData("RegistrationDetails.xlsx", "Details");
	}
	@BeforeMethod
	public void NaivateToUrl() {
		
		driver.get(Actions.getProperty("url"));
	}
	
	@Test
	public void NegativeScenarios() {
		
		registr.VerifyAllFields();
		registr.VerifyFieldValidationMessage();
		registr.VerifyErrorFieldValidation();
		
	}
	
	@Test(dataProvider="iterator")
	public void PositiveScenario(String firstName,String lastName,String department,String userName,String passowrd,String confirmPassowrd,	String email,String phoneNumber){
		
		registr.registerUser(firstName, lastName, department, userName, passowrd, confirmPassowrd, email, phoneNumber);
	}
	
	@AfterSuite(alwaysRun=true)
	
	public static void tearDown(){
		Actions.softAssert.assertAll();
		WebdriverFactory.closeWebDriver();
	}

}
