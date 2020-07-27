package com.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.LoggerHelper;
import com.pageObjects.LoginPage;
import com.pageObjects.PO_HomePage;
import com.testbase.ExcelReader;

import resources.TestBase;

public class HomePage extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(HomePage.class);
	// WebDriver driver;
	PO_HomePage page;
	Properties prop = new Properties();
	ExcelReader read = new ExcelReader();
	ArrayList<String> list = new ArrayList<String>();

	@Test
	public void searchProduct() throws InterruptedException {
		try {

			page = new PO_HomePage(driver);

			list = read.getData("SearchProduct", "Product");
			Thread.sleep(3000);
			Assert.assertNotEquals(page.getUserName(),"Login");
			//log.info("=======User not logged in========");
			page.clickSearchBar();
			page.searchText(list.get(0));
			String title=page.getSearchTitle();
			if(title.contains(list.get(0)))
			{
			log.info("================Search result appear===================");
			}
			else
			{
				log.error("==========Result not founf========");
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
