package com.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;

public class WebdriverFactory {
	
 static WebDriver driver;

static ChromeOptions options = new ChromeOptions();
static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static WebDriver intialiseWebDriver(String browser) {
		
			switch (browser.toLowerCase()) {

			case "chrome":

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");//System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
		
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				break;
		// Firefox version supported is till 47.0.1		
			case "firefox":

				FirefoxProfile profile = new FirefoxProfile();
				profile.setAssumeUntrustedCertificateIssuer(false);
				
				profile.setPreference("network.proxy.type", 1);
				profile.setPreference("network.proxy.http", "localHost");
				profile.setPreference("newtwork.proxy.http_port", 3128);

				// Download setting
				profile.setPreference("browser.download.folderlist", 2);
				profile.setPreference("browser.helperapps.neverAsk.saveToDisk", "jpeg");
//				profile.setPreference("browser.download.dir", downloadFilepath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				break;
		
				
			default:
			
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");//System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;

			}
		
		return driver;	
}
	public static  WebDriver getWebDriver() {
		return driver;
	}
	
	public static void closeWebDriver(){
		driver.quit();
		driver.close();
	}
}
