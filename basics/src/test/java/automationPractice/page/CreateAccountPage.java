package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import automationPractice.foundation.DriverDocPage;

public class CreateAccountPage extends DriverDocPage{
	
	private String url = "?controller=authentication&back=my-account#account-creation";
	
	@FindBy(how=How.CSS, using="input#customer_firstname")
	private WebElement customerFirstName;
	
	@FindBy(how=How.CSS, using="input#customer_lastname")
	private WebElement customerLastName;
	
	@FindBy(how=How.CSS, using="input#email")
	private WebElement email;
	
	@FindBy(how=How.CSS, using="input#passwd")
	private WebElement password;
	
	@FindBy(how=How.CSS, using="input#firstname")
	private WebElement firstName;
	
	@FindBy(how=How.CSS, using="input#lastname")
	private WebElement lastName;
	
	@FindBy(how=How.CSS, using="input#address1")
	private WebElement address;
	
	@FindBy(how=How.CSS, using="input#city")
	private WebElement city;
	
	@FindBy(how=How.CSS, using="select#id_state")
	private WebElement state;
	
	@FindBy(how=How.CSS, using="input#postcode")
	private WebElement zipCode;
	
	@FindBy(how=How.CSS, using="input#phone_mobile")
	private WebElement phoneNumber;
	
	@FindBy(how=How.CSS, using="button#submitAccount")
	private WebElement register;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		super.goToUrl(url);
	}

	public MyAccountPage fillPersonalInformation() {
		customerFirstName.sendKeys("Gracy");
		customerLastName.sendKeys("Gomes");
		email.sendKeys("");
		password.sendKeys("gracy");
		address.sendKeys("1523 Forest Road");
		city.sendKeys("Newark");
		
		Select findstate = new Select(state);
		findstate.selectByVisibleText("Alabama");
		
		zipCode.sendKeys("70001");
		phoneNumber.sendKeys("5634127895");
		register.click();
		
		return new MyAccountPage(this.driver);
	}
}
