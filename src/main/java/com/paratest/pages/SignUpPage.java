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

public class SignUpPage extends BaseTest {
	
	XSSFSheet sheet;
    XSSFWorkbook workbook;
    WebDriver driver=getDriver();
	
	public SignUpPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	
	//@FindBy(css="input.customer.firstName")
	@FindBy(name="customer.firstName")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='customer.lastName']")
	private WebElement lastName;
	@FindBy(name="customer.address.street")
	private WebElement custAddress;
	@FindBy(name="customer.address.city")
	private WebElement custCity;
	@FindBy(name="customer.address.state")
	private WebElement custState;
	@FindBy(name="customer.address.zipCode")
	private WebElement zipCode;
	@FindBy(name="customer.phoneNumber")
	private WebElement custphoneNumber;
	@FindBy(name="customer.ssn")
	private WebElement custSSN;
	@FindBy(name="customer.username")
	private WebElement userName;
	@FindBy(name="customer.password")
     private WebElement passWord;
	@FindBy(name="repeatedPassword")
	private WebElement confirmPassword;
	@FindBy(xpath="//input[@type='submit' and @value='Register']")
	private WebElement registerButton;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerLink;
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully')]")
	private WebElement successMsg;
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logOutLink;
	
	

public void fillSignUpForm(Map<String,String> data){
		registerLink.click();
		firstName.sendKeys(data.get("FirstName"));
		
		lastName.sendKeys(data.get("LastName"));
		custAddress.sendKeys(data.get("CustomerAddress"));
	    custCity.sendKeys(data.get("CustomerCity"));
		custState.sendKeys("kkk");
		zipCode.sendKeys("78755");
		custphoneNumber.sendKeys("9079709788");
		custSSN.sendKeys("1111111344");
		userName.sendKeys(randomString(8));
		passWord.sendKeys("uniq21243");
		confirmPassword.sendKeys("uniq21243");
		registerButton.click();
		logOutLink.click();
		
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
	



