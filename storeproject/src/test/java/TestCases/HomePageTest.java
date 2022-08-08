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
public class HomePageTest extends BaseClass {
	
	IndexPage indexPage;
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
	
	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyWishList(String username , String password) throws Throwable {
		Log.startTestCase("verifyWishList");
		indexPage=new IndexPage();
		loginPage=indexPage.clickonsignin();
		homePage=loginPage.login(username,password);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("verifyWishList");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyOrderHistory(String username , String password) throws Throwable {
		Log.startTestCase("verifyOrderHistory");
		indexPage=new IndexPage();
		loginPage=indexPage.clickonsignin();
		homePage=loginPage.login(username,password);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("verifyOrderHistory");
	}
	
	
	

}
