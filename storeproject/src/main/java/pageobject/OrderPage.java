/**
 * 
 */
package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

/**
 * @author Sanket
 *
 */
public class OrderPage extends BaseClass {

	@FindBy (xpath = "//span[contains(text(),'$16.51')]") 
	private WebElement unitprice;
	@FindBy (xpath = "//span[@id='total_price']") 
	private WebElement totalprice;
	@FindBy (xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]") 
	private WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public double getUnitPrice() {
		String unitPrice1 = unitprice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Integer.parseInt(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalprice.getText();
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Integer.parseInt(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		action.click(getDriver(), proceedToCheckout);
		return new LoginPage();
	}
	
	
	
}
