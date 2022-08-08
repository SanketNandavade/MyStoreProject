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
public class ShippingPage extends BaseClass {
	
	@FindBy (name = "processCarrier") private WebElement proceedToCheckOutbtn;
	@FindBy (xpath = "//input[@id='cgv']") private WebElement agree;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public void clickonAgree() {
		action.click(getDriver(), agree);
	}
	
	public PaymentPage clickOnProceedToCheck() {
		action.click(getDriver(), proceedToCheckOutbtn);
		return new PaymentPage();
	}
	

}
