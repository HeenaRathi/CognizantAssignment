package com.pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.ExcelReader;

import resources.TestBase;


public class LoginPage extends TestBase {

	private final static Logger log = Logger.getLogger(LoginPage.class.getName());
	@FindBy(xpath="//a[@class='_3Ep39l']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement pswd;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submit;
	
	ExcelReader read= new ExcelReader();
	Properties prop= new Properties();
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
		Alert al=driver.switchTo().alert();
		
		al.dismiss();
			
		log.info("click on sign in and object is:-" + loginButton.toString());
	}
	
	public void getEmailAddress(String email)
	{
		this.emailAddress.sendKeys(email);
	}
	
	public void getPassword(String pswd)
	{
		this.pswd.sendKeys(pswd);
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	public void logintoFlipkart(String emailad, String password) throws IOException
	{
		//clickOnLogin();
		/*getEmailAddress(emailad);
		getPassword(password);*/
		emailAddress.sendKeys(emailad);
		pswd.sendKeys(password);		
		clickOnSubmit();
	}
	
	public void getTitle()
	{
		String title=driver.getTitle();
		if(title.contains("Online Shopping"))
		{
			log.info("=========Landed to HomePage=======");
		}
		else
		{
			log.error("=======Failed to navigate to homePage========"+title);
		}
		
	}
}
