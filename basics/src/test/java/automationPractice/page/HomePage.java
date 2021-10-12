package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class HomePage extends DriverDocPage{
	private String home = "";

	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement signInButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='homefeatured']/li[4]/div/div[2]/h5/a")
	private WebElement productTitle;
		
	@FindBy(how=How.XPATH, using="//*[@id='homefeatured']/li[4]/div/div[1]/div/a[1]/img")
	private WebElement productImage;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		super.goToUrl(home);
	}

	public AuthenticationPage clickSignInButton() {
		signInButton.click();
		return new AuthenticationPage(this.driver);
	}
	
	public ProductDetailsPage clickOnProductTitle() {
		productTitle.click();
		return new ProductDetailsPage(this.driver);
	}
	
	public ProductDetailsPage clickOnProductImage() {
		productImage.click();
		return new ProductDetailsPage(this.driver);
	}
}
