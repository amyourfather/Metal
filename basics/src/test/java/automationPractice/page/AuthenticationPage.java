package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class AuthenticationPage extends DriverDocPage {
	
	private String url = "?controller=authentication&back=my-account";
	
	@FindBy(how=How.CSS, using="input#email")
	private WebElement email;
	
	@FindBy(how=How.CSS, using="input#passwd")
	private WebElement password;
	
	@FindBy(how=How.CSS, using="button#SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(how=How.CSS, using="#login_form> div>p.lost_password.form-group>a")
	private WebElement forgotPassword;
	
	@FindBy(how=How.CSS, using="input#email_create")
	private WebElement newEmail;
	
	@FindBy(how=How.CSS, using="button#SubmitCreate")
	private WebElement createAccountButton;

	public AuthenticationPage(WebDriver driver) {
		super(driver);
		super.goToUrl(url);
	}
	
	public MyAccountPage fillLoginCredentials() {
		email.sendKeys("gracy21@gmail.com");
		password.sendKeys("gracy");
		signInButton.click();
		
		return new MyAccountPage(this.driver);
	}
	
	public PasswordResetPage clickForgotPassword() {
		forgotPassword.click();
		
		return new PasswordResetPage(this.driver);
	}
	
	public CreateAccountPage clickCreateAccountButton() {
		newEmail.sendKeys("gracy754@gmail.com");
		createAccountButton.click();
		
		return new CreateAccountPage(this.driver);
	}
}
