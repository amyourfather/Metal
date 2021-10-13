package automationPractice.page;

import org.openqa.selenium.WebDriver;

import automationPractice.foundation.DriverDocPage;

public class SearchResultPage extends DriverDocPage {

	private String resultUrl = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Shirt&submit_search=";
	
	public String getResultUrl() {
		return resultUrl;
	}
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

}
