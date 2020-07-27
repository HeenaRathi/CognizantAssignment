package com.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.LoggerHelper;
import com.pageObjects.LoginPage;
import com.testbase.ExcelReader;

import resources.TestBase;

public class Login extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(Login.class);
	//WebDriver driver;
	LoginPage login;
	Properties prop = new Properties();
	ExcelReader read = new ExcelReader();
	ArrayList<String> list = new ArrayList<String>();

	@BeforeTest
	public void initializeDriver() throws IOException
	{
		log.info("===========Invoking browser =============");
		
		driver=init();
	}
	
	@Test
	public void loginApp() {
		try {
			
			login = new LoginPage(driver);
			prop=loadData();
			String sheet = prop.getProperty("sheetName");
			System.out.println(sheet);
			list = read.getData(sheet, "Username");
			System.out.println(list);
			login.logintoFlipkart(list.get(0), list.get(1));
			log.info("================Login Successfully===================");
			login.getTitle();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void quitDriver()
	{
		driver.close();
	}
}
