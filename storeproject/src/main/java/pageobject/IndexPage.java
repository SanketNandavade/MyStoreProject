package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy (xpath = "//a[@class='login']") private WebElement signinbtn;
	@FindBy (xpath = "//img[@class='logo img-responsive']") private WebElement storelogo;
	@FindBy (xpath = "//input[@id='search_query_top']") private WebElement serchbox;
	@FindBy (xpath = "//button[@class='btn btn-default button-search']") private WebElement clickonsearchbtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action = new Action();
	
	public LoginPage clickonsignin() throws Throwable {
		action.click(getDriver(), signinbtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return action.isDisplayed(getDriver(), storelogo);
	}
	
	public String getstoreTitle() {
		String mystoreTitle=getDriver().getTitle();
		return mystoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(serchbox, productName);
		action.click(getDriver(), clickonsearchbtn);
		return new SearchResultPage();
	}
	
}
