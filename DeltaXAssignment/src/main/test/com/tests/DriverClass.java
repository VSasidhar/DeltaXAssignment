package com.tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pages.RegistrationPage;
import com.utils.ExcelReader;
import com.utils.WebdriverFactory;

public class DriverClass{
	RegistrationPage registr = new RegistrationPage();
	 static WebDriver driver;
	@Parameters({"browserName"})
	@BeforeTest
	public void testInit(String browserName) throws InterruptedException{
		driver= WebdriverFactory.intialiseWebDriver(browserName);
		driver.get("http://adjiva.com/qa-test/");
	}
	
	@DataProvider(name="iterator")
	public Object[][] GetTestData() throws IOException{
		return ExcelReader.readExcelData("UserDetails.xlsx", "UserDetails");
	}
	
	@Test
	public void TestCase1() {
		
		registr.VerifyAllFields();
		registr.VerifyFieldValidationMessage();
		registr.VerifyErrorFieldValidation();
		
	}
	
/*//	@Test(dataProvider="iterator")
	public void PositiveScenario(String firstName, String lastName, String department, String userName, String passowrd, String confirmPassowrd, String email, String phoneNumber){
		
		registr.registerUser(firstName, lastName, department, userName, passowrd, confirmPassowrd, email, phoneNumber);
	}*/
	
	

}
