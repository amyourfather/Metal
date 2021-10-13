package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class MyAccountPage extends DriverDocPage{

	private String url = "?controller=my-account";
	
	@FindBy(how=How.CSS, using="#header_logo>a>img")
	private WebElement logo;
	
	@FindBy(how=How.CSS, using="#center_column>div>div:nth-child(2)>ul>li>a")
	private WebElement wishlist;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		super.goToUrl(url);
	}
	
	public HomePage clickOnYourLogo(){
		logo.click();
		return new HomePage(this.driver);
	}
	
	public WishListPage clickOnWishList() {
		wishlist.click();
		return new WishListPage(this.driver);
	}
}
