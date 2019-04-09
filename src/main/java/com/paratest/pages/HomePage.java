package com.paratest.pages;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paratest.utilities.ExcelUtility;

import junit.framework.Assert;

public class HomePage extends BaseTest {
	
	XSSFSheet sheet;
    XSSFWorkbook workbook;
    WebDriver driver=getDriver();
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	
	//@FindBy(css="input.customer.firstName")
	@FindBy(xpath="//a[contains(@href,'about.htm')]")
	private WebElement aboutUsLink;
	@FindBy(xpath="//a[contains(@href,'services.htm')]")
	private WebElement servicesLink;
		
	

public void navigateAboutusLink(){
	aboutUsLink.click();
		
	}
	

public void navigateservicesLink(){
	servicesLink.click();
		
	}
	
		

		String randomString( int len ){
			final String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rnd = new SecureRandom();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( str.charAt( rnd.nextInt(str.length()) ) );
		   return sb.toString();
		}
		}
	



