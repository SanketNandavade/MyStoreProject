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
public class SearchResultPage extends BaseClass {
	
	@FindBy (xpath = "//*[@id=\"center_column\"]//img") private WebElement productResult;

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public boolean isProductAvailable() {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	
}
