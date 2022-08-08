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
import pageobject.IndexPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage ip;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		ip = new IndexPage();
		boolean result=ip.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String acttitle=ip.getstoreTitle();
		Assert.assertEquals(acttitle, "My Store");
		Log.endTestCase("verifyTitle");
	}
	
	
}
