package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	// public WebEventListener eventListener;
	public Properties OR = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;

	public Properties loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
		return OR;

	}

	public WebDriver init() throws IOException {
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void getUrl(String url) {
		log.info("navigating to :-" + url);
		driver.get(url);
		//driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void selectBrowser(String browser) {
		
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				// eventListener = new WebEventListener();

			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver");
				driver = new ChromeDriver();

			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "\\drivers\\geckodriver");
				driver = new FirefoxDriver();

				// eventListener = new WebEventListener();

			}
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));

	}
	public String getChildWindow(WebDriver driver)
	{
		Set<String> win = driver.getWindowHandles();
		Iterator<String> wi=win.iterator();
		String paent=wi.next();
		String child= wi.next();
		System.out.println(child);
		return child;
	}
}
