package automationPractice.page;

import org.openqa.selenium.WebDriver;

import automationPractice.foundation.DriverDocPage;

public class ProductDetailPage extends DriverDocPage {
	
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

}
