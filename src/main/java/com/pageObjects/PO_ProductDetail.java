package com.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Helper.LoggerHelper;
import com.gargoylesoftware.htmlunit.Page;
import resources.TestBase;

public class PO_ProductDetail extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(PO_ProductDetail.class);

	@FindBy(xpath = "//div[@class='_3e7xtJ']/div/div[2]/div[4]")
	WebElement productTitle;

	@FindBy(xpath = "//span[@class='_35KyD6']")
	
	public static WebElement productName;

	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	public static WebElement productPrice;

	@FindBy(xpath = "//div[@class='g2dDAR']")
	WebElement productDesc;

	WebDriver driver;
	
	public static String camName="";

	public PO_ProductDetail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnProduct() {

		log.info("product is=="+productTitle.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		waitForElement(driver, 15, productTitle);
		productTitle.click();
		if(productTitle.isEnabled())
		{
		log.info("============Select the product====");
		}
		else
		{
			log.error("====Not selected=======");
		}

	}

	public String getSearchTitle() {
		// TODO Auto-generated method stub
		return productTitle.getText();
	}

	public static String getProductName() {
		camName=productName.getText();
		return camName ;
	}

	public static String getProductPrice() {
		return productPrice.getText();
	}
	
	public String getProductdesc() {
		return productDesc.getText();
	}
	
	
}
