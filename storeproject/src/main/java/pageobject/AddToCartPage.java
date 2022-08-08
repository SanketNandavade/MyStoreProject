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
public class AddToCartPage extends BaseClass {
	
	@FindBy (id = "quantity_wanted") 
	private WebElement quantity;
	@FindBy (name = "group_1") 
	private WebElement size;
	@FindBy (xpath = " //button[@class='exclusive']") 
	private WebElement addToCartbtn;
	@FindBy (xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']") 
	private WebElement addtoacrtmessage;
	@FindBy (xpath = "//span[normalize-space()='Proceed to checkout']") 
	private WebElement proceedToCheckout; 
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public void enterQuantity(String Qunt) {
		action.type(quantity, Qunt);
	}
	
	public void selectSize(String s) {
		action.selectByValue(size, s);
	}
	
	public void clickOnAddToCart() {
		action.click(getDriver(), addToCartbtn);
	}
	
	public boolean validateAddToCart() {
		action.explicitWait(getDriver(), addtoacrtmessage, 100);
		return action.isDisplayed(getDriver(), addtoacrtmessage);
	}
	
	public OrderPage clickoncheout() {
		action.explicitWait(getDriver(), proceedToCheckout, 100);
		action.click(getDriver(), proceedToCheckout);
		return new OrderPage();
	}

}
