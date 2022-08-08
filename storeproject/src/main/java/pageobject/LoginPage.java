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
public class LoginPage extends BaseClass {
	
	@FindBy (id = "email") private WebElement userName;
	@FindBy (id = "passwd") private WebElement password;
	@FindBy (id = "SubmitLogin") private WebElement submitebtn;
	@FindBy (id = "email_create") private WebElement emailForNewAccount;
	@FindBy (id = "SubmitCreate") private WebElement createNewAccountbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public HomePage login(String uname, String pswd) {
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), submitebtn);
		return new HomePage();
	}

	public AddressPage login1(String uname, String pswd) {
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), submitebtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), createNewAccountbtn);
		return new AccountCreationPage();
	}


	
	
	
	

}
