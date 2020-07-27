package com.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.LoggerHelper;
import com.pageObjects.LoginPage;
import com.pageObjects.PO_AddToCart;
import com.pageObjects.PO_HomePage;
import com.pageObjects.PO_ProductDetail;
import com.testbase.ExcelReader;

import resources.TestBase;

public class AddtoCart extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(AddtoCart.class);
	// WebDriver driver;
	PO_AddToCart pag ;
	PO_ProductDetail prod;
	Properties prop = new Properties();
	ExcelReader read = new ExcelReader();
	ArrayList<String> list = new ArrayList<String>();

	@Test
	public void addProduct() throws IOException, InvalidFormatException {
		
		pag = new PO_AddToCart(driver);
		prod= new PO_ProductDetail(driver);
		pag.addProduct();
		log.info("Product added Successfully");

		log.info("=====Verify Product Details========");
		String proName=prod.getProductName();
		String cartProd= pag.getProductName();
		Assert.assertEquals(proName, cartProd);
		log.info("===Product Name Added==="+proName);
		
		//pag.verifyProduct();
		
		String proPrice=prod.getProductPrice();
		String cartPrice= pag.getProductPrice();
		Assert.assertEquals(proPrice, cartPrice);
		log.info("===Product Price ==="+proPrice);
		waitForElement(driver, 10, pag.placeOrder);
		
		pag.placeOrder();
		
		
	}



}
