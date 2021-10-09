package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class WishListPage extends DriverDocPage{
	
	private String url = "?fc=module&module=blockwishlist&controller=mywishlist";

	@FindBy(how=How.CSS, using="#wishlist_39790>td:nth-child(5)>a")
	private WebElement view;
	
	@FindBy(how=How.CSS, using="#wlp_4_16>div>div:nth-child(1)>div>a>img")
	private WebElement productThumbnail;
	
	public WishListPage(WebDriver driver) {
		super(driver);
		super.goToUrl(url);
	}
	
	public ProductDetailsPage clickOnProductThumnail() {
		view.click();
		productThumbnail.click();
		return new ProductDetailsPage(this.driver);
	}
}
