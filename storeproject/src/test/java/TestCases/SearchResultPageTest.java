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
import pageobject.IndexPage;
import pageobject.SearchResultPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class SearchResultPageTest extends BaseClass  {

	IndexPage indexPage;
	SearchResultPage searchresultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void verifyProductIsAvailable(String product) {
		Log.startTestCase("verifyProductIsAvailable");
		indexPage = new IndexPage();
		Log.info("Entering product for search");
		searchresultPage=indexPage.searchProduct(product);
		boolean result = searchresultPage.isProductAvailable();
		Assert.assertTrue(result);	
		Log.endTestCase("verifyProductIsAvailable");
	}
	
	
	
}
