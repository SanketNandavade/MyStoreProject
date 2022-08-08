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
public class AddressPage extends BaseClass {

	@FindBy (name = "processAddress") private WebElement proceedToCheckout;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public ShippingPage clickonProceedToCheckOut() {
		action.click(getDriver(), proceedToCheckout);
		return new ShippingPage();
	}
	
	
}
