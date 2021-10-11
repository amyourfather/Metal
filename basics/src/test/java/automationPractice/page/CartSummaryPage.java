package automationPractice.page;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationPractice.foundation.DriverDocPage;

public class CartSummaryPage extends DriverDocPage {

	private final String productListXpath = "//table[@id = 'cart_summary']//tbody//tr";
	private final String checkOutXpath = "//a[@title = 'Proceed to checkout' and @class ='button btn btn-default standard-checkout button-medium']";
	HashMap<String, String> productMap;
	
	public CartSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public HashMap<String, String> getProductMap() {
		HashMap<String, String> result = new HashMap<String, String>();
		
		List<WebElement> locations = driver.findElements(By.xpath(productListXpath));
		int size = locations.size();
		for(int i = 1; i <= size; i++) {
			String productXpath = "//table[@id = 'cart_summary']//tbody//tr[" + i +"]//td[@class ='cart_description']";
			String[] productDetail = super.GetTexts(productXpath);
			for(int j = 0; j < productDetail.length; j++) {
				String[] productNameAndId = productDetail[j].split("\n");
				String productName = productNameAndId[0];
				String productId = productNameAndId[1].substring(6);
				result.put(productName, productId);
			}
		}
		this.productMap = result;
		return result;
		
	}
	
	public Set<?> getProductMapAndReturnKeySet() {
		return this.productMap.keySet();
	}
	
	public CheckOutPage NavigateToCheckOut() {
		super.Click(checkOutXpath);
		return new CheckOutPage(driver);
	}

}
