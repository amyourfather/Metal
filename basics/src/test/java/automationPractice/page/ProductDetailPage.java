package automationPractice.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationPractice.foundation.DriverDocPage;

public class ProductDetailPage extends DriverDocPage {
	
	private String ProductXpath;
	private String ProductDetailUrl;
	private String ProductPriceXpath;
	private String ProductReviewXpath;

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage(WebDriver driver, String ProductXpath, String ProductDetailUrl) {
		super(driver);
		this.ProductXpath = ProductXpath;
		this.ProductDetailUrl = ProductDetailUrl;
	}

	public String checkForPrice(String productPriceXpath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement priceXpath = driver.findElement(By.xpath(productPriceXpath));
		String productPrice = priceXpath.getText();
		return productPrice;	
	}
	
	public String checkForReviews(String productReviewXpath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement reviewXpath = driver.findElement(By.xpath(productReviewXpath));
		String productReview = reviewXpath.getText();
		return productReview;
	}

	
}
