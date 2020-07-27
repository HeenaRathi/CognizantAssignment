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

public class PO_AddToCart extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(PO_AddToCart.class);

	@FindBy(xpath = "//a[@class='_325-ji _3ROAwx']")
	WebElement prodName;

	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	WebElement prodPrice;

	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addButton;
	
	@FindBy(xpath="//button[@class='_2AkmmA iwYpF9 _7UHT_c']")
	public static WebElement placeOrder;
	
	@FindBy(xpath="//div[@class='_6ATDKp']")
	WebElement radioAddress;
	
	@FindBy(xpath="//button[@class='_2AkmmA _I6-pD _7UHT_c']")
	WebElement selectAddress;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Q4i61 _7UHT_c']")
	WebElement orderSummary;
	
	@FindBy(xpath="//button[@class='_2AkmmA _3xlGPC _7UHT_c']")
	WebElement payButton;

	public PO_AddToCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return prodName.getText();
	}

	public String getProductPrice() {
		return prodPrice.getText();
	}
	
	public WebElement getDeliverOption()
	{
		return selectAddress;
	}

	public void addProduct()
	{
		log.info("====Adding product====");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		if(addButton.isEnabled())
		{
			log.info("Click on Add to cart===");
			addButton.click();
		}
		else
		{
			log.info("Button is not enabled");
		}
	}
	
	public void verifyProduct()
	{
		String prodList= PO_ProductDetail.getProductName();
		String cartProd= getProductName();
		Assert.assertEquals(prodList, cartProd);
	}
	
	public void placeOrder()
	{
		if(placeOrder.isEnabled())
		{
			log.info("===Clicking on Place Order====");
			placeOrder.click();
		}
		else
		{
			log.info("Button is not enabled");
		}
		waitForElement(driver, 10, radioAddress);
		radioAddress.click();
		selectAddress.click();
		waitForElement(driver, 5, orderSummary);
		log.info("=====Address Selected====");
		orderSummary.click();
		
		
	}
	
	}
