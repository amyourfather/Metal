package automationPractice.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationPractice.foundation.DriverDocPage;

public class CheckOutPage extends DriverDocPage {

	private final String createAccountformXpath = "//form[@id = 'create-account_form']//h3";
	private final String inputEmailLoginXpath = "//input[@class = 'is_required validate account_input form-control' and @id = 'email']";
	private final String inputPasswordLoginXpath = "//input[@class = 'is_required validate account_input form-control' and @id = 'passwd']";
	private final String signInButtonXpath = "//button[@id = 'SubmitLogin']";
	private final String deliveryAddressBoxXpath = "//ul[@id ='address_delivery']";
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCreateAccountTextIfExist() {
		return super.GetText(createAccountformXpath);
	}
	
	public CheckOutPage inputEmailPasswdAndLogin(String email, String pw) {
		this.fillInText(inputEmailLoginXpath, email);
		this.fillInText(inputPasswordLoginXpath, pw);
		super.Click(signInButtonXpath);
		return this;
	}
	
	private void fillInText(String xpath, String text) {
		WebElement fillInPlace = driver.findElement(By.xpath(xpath));
		fillInPlace.sendKeys(text);
	}
	
	public String[] getDeliveryAddressBoxTexts() {
		return super.GetTexts(deliveryAddressBoxXpath);
	}
}
