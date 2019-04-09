package com.paratest.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paratest.pages.BaseTest;
import com.paratest.pages.HomePage;
import com.paratest.pages.SignUpPage;
import com.paratest.utilities.ExcelUtility;

import junit.framework.Assert;



public class HomePageTest extends BaseTest{


	XSSFSheet sheet;
    XSSFWorkbook workbook;

	HomePage homepage;


	@Test()
	public void AboutUSTest(){
	
		homepage = new HomePage(getDriver());
		homepage.navigateAboutusLink();
		Assert.assertEquals("ParaBank | About Us", driver.getTitle());
		
	}
	

	@Test()
	public void serviceLinkTest(){
	
		homepage = new HomePage(getDriver());
		homepage.navigateservicesLink();
		Assert.assertEquals("ParaBank | Services", driver.getTitle());
		
	}
	

	 @AfterMethod
	 public void captureScreen(ITestResult result) throws IOException
	 {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
	   
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	  }
	  extent.flush();
		driver.close();
		driver.quit();
	 }
	
	@AfterTest
	public void tearDown(){
	    //  driver.quit();
	}
		
	

}
