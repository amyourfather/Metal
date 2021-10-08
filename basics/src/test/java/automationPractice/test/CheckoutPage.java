package automationPractice.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationPractice.foundation.DriverDocPage;

public class CheckoutPage extends DriverDocPage{
	private String checkoutPageUrl = "http://automationpractice.com/index.php?controller=order";
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCheckoutUrl() {
		return checkoutPageUrl;
	}
	
	public CheckoutPage clickCheckoutButton(checkoutButtonXpath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement checkoutButton = driver.findElement(By.xpath(checkoutButtonXpath))
	}
}

