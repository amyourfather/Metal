package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class ProductDetailsPage extends DriverDocPage {
	
	private String url = "?id_product=4&controller=product";
	
	@FindBy(how=How.CSS, using="#add_to_cart>button")
	private WebElement addToCartButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(how=How.CSS, using="a#wishlist_button")
	private WebElement addToCartWishList;
	
	@FindBy(how=How.CSS, using="#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
	private WebElement close;
	
	@FindBy(how=How.CSS, using="#product_reference>span")
	private WebElement productDemoId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement userName;
	
	public ProductDetailsPage(WebDriver webDriver) {
		super(webDriver);
		super.goToUrl(url);
	}
	
	public String getProductDemoId() {
		String text = productDemoId.getText();
		System.out.println(text);
		return text;
	}
	
	public ShoppingCartPage clickAddToCart() {
		addToCartButton.click();
		proceedToCheckoutButton.click();
		return new ShoppingCartPage(this.driver);
	}
	
	public MyAccountPage clickAddToWishListThenUserName() {
		addToCartWishList.click();
		close.click();
		userName.click();
		return new MyAccountPage(this.driver);
	}
}
