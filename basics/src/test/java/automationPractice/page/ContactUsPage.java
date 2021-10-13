package automationPractice.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import automationPractice.foundation.DriverDocPage;

public class ContactUsPage extends DriverDocPage {

	private final String messageareaXpath = "//textarea";
	private final String emailInputXpath = "//input[@id = 'email']";

	@FindBy(how=How.ID, using="id_contact")
	private WebElement subjectHeadingElement;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}


	public void fillInMessage(String message) {
		this.FillInText(messageareaXpath, message);
	}

	public void fillInEmail(String email) {
		this.FillInText(emailInputXpath, email);
	}

	public ContactUsPage chooseSubjectHeading(String subject) {
		Select dropdownList = new Select(subjectHeadingElement);
		dropdownList.selectByVisibleText(subject);
		return this;
	}

	private void FillInText(String xpath, String text) {
		WebElement fillInPlace = driver.findElement(By.xpath(xpath));
		fillInPlace.sendKeys(text);
	}

	public ContactUsPage submitForm(String subjectHeading, String emailAddress, String message) {
		chooseSubjectHeading(subjectHeading);
		fillInEmail(emailAddress);
		fillInMessage(message);
		super.Click("//button[@name = 'submitMessage']");
		super.GetText("//p[@class = 'alert alert-success']");
		return this;		
	}
	
	public String getAlertText() {
		super.Click("//button[@name = 'submitMessage']");
		return super.GetText("//p[@class = 'alert alert-success']");
	}
}
