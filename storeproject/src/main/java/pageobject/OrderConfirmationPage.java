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
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy (xpath = "//strong[normalize-space()='Your order on My Store is complete.']") 
	private WebElement confirmmessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public String validateConfirmMessage() {
		String confirmmessagetext = confirmmessage.getText();
		 return confirmmessagetext;
	}

}
