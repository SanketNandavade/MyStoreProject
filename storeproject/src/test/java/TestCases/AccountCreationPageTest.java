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
import pageobject.AccountCreationPage;
import pageobject.IndexPage;
import pageobject.LoginPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountcreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "email", dataProviderClass = DataProviders.class, groups ="Sanity" )
	public void verifyAccountCreationPage(String mailid) throws Throwable {
		Log.startTestCase("verifyAccountCreationPage");
		indexPage = new IndexPage();
		loginPage=indexPage.clickonsignin();
		accountcreationPage=loginPage.createNewAccount(mailid);
		boolean result = accountcreationPage.validateAccountCreationPage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyAccountCreationPage");
	}
	

}
