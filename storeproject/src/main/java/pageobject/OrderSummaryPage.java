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
public class OrderSummaryPage extends BaseClass {
	
	@FindBy (xpath = "//button[@class='button btn btn-default button-medium']") 
	private WebElement confirmOrderbtn;

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public OrderConfirmationPage clickOnConfirmMyOrder() {
		action.click(getDriver(), confirmOrderbtn);
		return new OrderConfirmationPage();
	}
	
}


