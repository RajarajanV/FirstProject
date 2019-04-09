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
import com.paratest.pages.SignUpPage;
import com.paratest.utilities.ExcelUtility;

import junit.framework.Assert;



public class SignUpTest extends BaseTest{


	XSSFSheet sheet;
    XSSFWorkbook workbook;

	SignUpPage signUp ;


	@Test(priority=0,dataProvider="testdata", dataProviderClass = ExcelUtility.class)
	public void fillSignUp(Map<String,String> data){
	
		signUp = new SignUpPage(getDriver());
		signUp.fillSignUpForm(data);
		//Assert.assertEquals("Your account was created successfully. You are now logged in.", successMsg.getText());
		
	}
	
	

	@Test()
	public void anydata(){

		Assert.assertEquals("2","2");
		
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
	
		driver.close();
		driver.quit();
	 }
	
	@AfterTest
	public void tearDown(){
	    //  driver.quit();
		
	}
		
	

}
