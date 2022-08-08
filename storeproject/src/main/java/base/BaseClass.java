/**
 * 
 */
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;



/**
 * @author Sanket
 *
 */
public class BaseClass {
	
	public static Properties prop;
//	public static WebDriver driver;
	
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	// Initilize log4j.xml file
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		//loadConfig method is to load the configuration
		try {
			prop = new Properties();
			FileInputStream ip = new 
		    FileInputStream("D:\\Java\\storeproject\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp(String browserName) {
		
		WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//Set Browser To ThreadLocalmap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		
		//Maximize the screen
		getDriver().manage().window().maximize();
		
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

    @AfterSuite
	public void aftersute() {
		ExtentManager.endReport();
	}
	

}
