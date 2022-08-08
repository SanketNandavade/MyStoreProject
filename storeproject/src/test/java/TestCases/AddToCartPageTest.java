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
import pageobject.AddToCartPage;
import pageobject.IndexPage;
import pageobject.SearchResultPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class, groups = {"Regression","Sanity"})
	public void verifyaddToCart(String product, String qty, String size) {
		Log.startTestCase("verifyaddToCart");
		indexPage = new IndexPage();
		searchresultPage=indexPage.searchProduct(product);
		addToCartPage=searchresultPage.clickOnProduct();
		Log.info("Entering quntity of Product");
		addToCartPage.enterQuantity(qty);
		Log.info("Entering Size of Product");
		addToCartPage.selectSize(size);
		Log.info("Click on Add To Cart Button");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		Log.endTestCase("verifyaddToCart");
	}

}
