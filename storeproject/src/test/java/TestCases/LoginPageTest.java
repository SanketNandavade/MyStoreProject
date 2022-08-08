/**
 * 
 */
package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobject.HomePage;
import pageobject.IndexPage;
import pageobject.LoginPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class LoginPageTest extends BaseClass {

	IndexPage ip;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pass) throws Throwable {
		Log.startTestCase("loginTest");
		ip = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = ip.clickonsignin();
		Log.info("Enter Username and Password");
		homePage=loginPage.login(uname,pass);
		String actualURL=homePage.getCurrURL();
		String expectURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if User is able to login");
		Assert.assertEquals(actualURL, expectURL);
		Log.info("Login is Sucessful");
	    Log.endTestCase("loginTest");
	}
	
	
	
	
}
