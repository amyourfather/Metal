package automationPractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automationPractice.foundation.DriverDocPage;

public class ShoppingCartPage extends DriverDocPage {

	private String url = "?controller=order";
	
	@FindBy(how=How.XPATH, using="//*[@id=\"product_4_16_0_578350\"]/td[2]/small[1]")
	private WebElement productDemoId; 

	public ShoppingCartPage(WebDriver webDriver) {
		super(webDriver);
		super.goToUrl(url);
	}
	
	public String productDescription() {
		String text = productDemoId.getText();
		System.out.println(text);
		return text;
	}
}
