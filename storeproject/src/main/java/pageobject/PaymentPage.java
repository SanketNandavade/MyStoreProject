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
public class PaymentPage extends BaseClass {

	@FindBy (xpath = "//a[@title='Pay by bank wire']") private WebElement payBybankWire;
	@FindBy (xpath = "//a[@title='Pay by check.']") private WebElement payByCheck;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public OrderSummaryPage clickOnpayment() {
		action.click(getDriver(), payBybankWire);
		return new OrderSummaryPage();
	}
	
	
	
}
