package com.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Helper.LoggerHelper;
import com.testcases.Login;

public class PO_HomePage {

	private final static Logger log = LoggerHelper.getLogger(PO_HomePage.class);
	@FindBy(xpath="//*[@class='_2aUbKa']")
	WebElement userName;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement searchBar;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement searchButton;
	WebDriver driver;
	
	
	public PO_HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getUserName()
	{
		String actual=userName.getText();
		/*if(actual.equalsIgnoreCase("Login"))
		{
			Assert.assertTrue(true);
			log.info("=====User not loggedin=========");
			
		}
		else
		{
			log.info(userName.getText()+"========User is Logged in==========");
		}*/
		return actual;
	}
	
	public void clickSearchBar()
	{
		log.info("=====Clicking on Search Bar=========");
		searchBar.click();
		
	}
	
	public void searchText(String text)
	{
		searchBar.sendKeys(text);
		searchButton.click();
		log.info("====Search Text Enter=====");
	}
	
	public String getSearchTitle()
	{
		String searchTitle=driver.findElement(By.xpath("//div[@class='_3UEiDE']/span")).getText();
		return searchTitle;
	}
}
