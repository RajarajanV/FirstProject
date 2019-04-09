package com.paratest.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.paratest.listeners.ExtentManager;

public class BaseTest {
	    protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected static ExtentReports extent = ExtentManager.createInstance();
	    protected static Properties prop;
		
		@BeforeMethod
		public void setUp()
		{
	String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\kanagalakshmi\\Documents\\Software\\Chromedriver\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
				driver = new FirefoxDriver(); 
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
			
		}
		
		public WebDriver getDriver(){
			return driver;
		}
	 

		
		public  BaseTest(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C://Users/kanagalakshmi/workspace/paratest/config.properties");

				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	

}


