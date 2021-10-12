package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class PasswordResetPage extends DriverDocPage{

	private String url = "?controller=password";
	
	@FindBy(how=How.CSS, using="#form_forgotpassword>fieldset>p>button")
	private WebElement retrievePassword;
	
	@FindBy(how=How.XPATH, using="//*[@id='center_column']/div/p")
	private WebElement confirmationMessage;
	
	@FindBy(how=How.CSS, using="input#email")
	private WebElement email;
	
	public PasswordResetPage(WebDriver driver) {
		super(driver);
		super.goToUrl(url);
	}

	public String resetPassword() {
		email.sendKeys("gracy21@gmail.com");
		retrievePassword.click();
		return confirmationMessage.getText();
	}
}
