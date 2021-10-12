package automationPractice.page;

import org.openqa.selenium.WebDriver;

import automationPractice.foundation.DriverDocPage;

public class ProductDetailPage extends DriverDocPage {
	
	private final String closepopupXpath = "//span[@title = 'Close window']";
	private final String AddtoCartXpath = "//p[@id = 'add_to_cart']/button";
	private final String ViewCartXpath = "//a[@title = 'View my shopping cart']";
	private final String CartUrl = "http://automationpractice.com/index.php?controller=order";
	private String ProductXpath;
	private String ProductDetailUrl;

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage(WebDriver driver, String ProductXpath, String ProductDetailUrl) {
		super(driver);
		this.ProductXpath = ProductXpath;
		this.ProductDetailUrl = ProductDetailUrl;
	}
	
	public ProductDetailPage addToCart() {
		super.Click(AddtoCartXpath);
		return this;
	}
	
	public ProductDetailPage addToCartAndClosePopUp() {
		this.addToCart();
		this.closePopUp();
		return this;
	}
	
	public ProductDetailPage closePopUp() {
		super.Click(this.closepopupXpath);
		return this;
	}
	
	public CartSummaryPage NavigateToCart() {
		super.ClickTo(ViewCartXpath, CartUrl);
		return new CartSummaryPage(driver);
	}

	public String getProductXpath() {
		return ProductXpath;
	}

	public String getProductDetailUrl() {
		return ProductDetailUrl;
	}
}
