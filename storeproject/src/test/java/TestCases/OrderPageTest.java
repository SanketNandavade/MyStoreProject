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
import pageobject.OrderPage;
import pageobject.SearchResultPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class, groups = "Regression")
	public void verifyTotalPrice(String product, String qty, String size) {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		Log.info("Entering product name");
		searchresultPage=indexPage.searchProduct(product);
		addToCartPage=searchresultPage.clickOnProduct();
		Log.info("Entering product quantity");
		addToCartPage.enterQuantity(qty);
		Log.info("Entering product size");
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickoncheout();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpectedPrice=((unitPrice*(Double.parseDouble(qty)))+2);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
	
	
	
	
	
}
