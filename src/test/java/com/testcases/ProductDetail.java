package com.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.LoggerHelper;
import com.pageObjects.LoginPage;
import com.pageObjects.PO_HomePage;
import com.pageObjects.PO_ProductDetail;
import com.testbase.ExcelReader;

import resources.TestBase;

public class ProductDetail extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(ProductDetail.class);
	// WebDriver driver;
	PO_ProductDetail page;
	Properties prop = new Properties();
	ExcelReader read = new ExcelReader();
	ArrayList<String> list = new ArrayList<String>();

	@Test
	public void searchProduct() throws IOException, InvalidFormatException {
		page = new PO_ProductDetail(driver);

		log.info("Landed====" + page);

		String title = page.getSearchTitle();
		page.clickOnProduct();
		driver.switchTo().window(getChildWindow(driver));

	}


}
