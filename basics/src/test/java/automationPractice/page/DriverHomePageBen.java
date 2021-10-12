package automationPractice.page;

import org.openqa.selenium.WebDriver;

import automationPractice.foundation.DriverDocPage;

public class DriverHomePageBen extends DriverDocPage {

	private String HomePageURL = "http://automationpractice.com/index.php";
	private final String ContactUsXpath = "//a[@title = 'Contact us']";
	public DriverHomePageBen(WebDriver driver) {
		super(driver);
	}
	
	public String getHomeUrl() {
		return HomePageURL;
	}
	
	public ProductDetailPage ClickToProductDetail(String ProductXpath, String ProductDetailUrl) {
		super.ClickTo(ProductXpath, ProductDetailUrl);
		return new ProductDetailPage(this.driver, ProductXpath, ProductDetailUrl);
	}

	public ContactUsPage NavigateToContacUs() {
		super.Click(ContactUsXpath);
		return new ContactUsPage(driver);
	}
}
