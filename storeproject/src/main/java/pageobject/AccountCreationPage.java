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
public class AccountCreationPage extends BaseClass {
	
	@FindBy (xpath = "//h1[@class='page-heading']") private WebElement fromTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Action action = new Action();
	
	public boolean validateAccountCreationPage() {
		return action.isDisplayed(getDriver(), fromTitle);
	}
}
