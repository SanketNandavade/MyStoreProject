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
import pageobject.AddressPage;
import pageobject.IndexPage;
import pageobject.LoginPage;
import pageobject.OrderConfirmationPage;
import pageobject.OrderPage;
import pageobject.OrderSummaryPage;
import pageobject.PaymentPage;
import pageobject.SearchResultPage;
import pageobject.ShippingPage;
import utility.Log;

/**
 * @author Sanket
 *
 */
public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderconfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tesrDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "getProduct" ,dataProviderClass = DataProviders.class ,groups = "Regression")
	public void endToEndTest(String product, String qty, String size) {
		Log.startTestCase("endToEndTest");
		indexPage = new IndexPage();
		searchresultPage=indexPage.searchProduct(product);
		addToCartPage=searchresultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickoncheout();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
//		loginPage.login1(username, pass);
		shippingPage=addressPage.clickonProceedToCheckOut();
		shippingPage.clickonAgree();
		paymentPage=shippingPage.clickOnProceedToCheck();
		orderSummaryPage=paymentPage.clickOnpayment();
		orderconfirmationPage=orderSummaryPage.clickOnConfirmMyOrder();
		String expMessage = orderconfirmationPage.validateConfirmMessage();
		String actMessage = "Your order on My Store is complete.";
		Assert.assertEquals(expMessage, actMessage);
		Log.endTestCase("endToEndTest");
		
	}
	
	
	
	
	
	
}
