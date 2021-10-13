package automationPractice.page;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automationPractice.foundation.DriverDocPage;
import automationPractice.page.CheckoutPage;

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
	
	public SearchResultPage ClickSearchBar(String searchBarXpath, String searchButtonXpath, String searchTerm, String productListXpath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement searchBar = driver.findElement(By.xpath(searchBarXpath));
		searchBar.sendKeys(searchTerm);
		driver.findElement(By.xpath(searchButtonXpath)).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productListXpath)));
		return new SearchResultPage(this.driver);
	}
	
	public CheckoutPage clickCheckoutButton(String checkoutButtonXpath, String orderDetailXpath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement checkoutButton = driver.findElement(By.xpath(checkoutButtonXpath));
		checkoutButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orderDetailXpath)));
		return new CheckoutPage(this.driver);
	}

	public ContactUsPage NavigateToContacUs() {
		super.Click(ContactUsXpath);
		return new ContactUsPage(driver);
	}
}
