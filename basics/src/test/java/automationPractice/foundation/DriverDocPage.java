package automationPractice.foundation;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import automationPractice.page.DriverHomePageBen;

public abstract class DriverDocPage {
	protected WebDriver driver;
	protected final long WaitTimeOut = 5;
	protected Duration NavWaitTimeOut = Duration.ofSeconds(10);
	protected Duration PollingMilSec = Duration.ofSeconds(10);
	//need to change later this is the place that saves the url
	protected String HomePageUrlBen = "http://automationpractice.com/index.php";
	
	public DriverDocPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	// for all the sub class name them as "DriversomethingsomethingPage"
	public DriverDocPage NavigateToPage(String URL) {
		
		if (URL == this.HomePageUrlBen) {
			driver.navigate().to(URL);
			//return new DriverHomePageBen(driver);
		}
		throw new IllegalArgumentException("you just entered an unsupported website URL: " + URL);
	}
	
	//Nanda added 
	public void goToUrl(String relativeUrl) {
		String fullUrl = this.HomePageUrlBen + relativeUrl;

		this.driver.navigate().to(fullUrl);		
	}
	
	//if nothing
	public void Click(String xpath) {
		WebElement button = driver.findElement(By.xpath(xpath));
		
		WebDriverWait wait = new WebDriverWait(driver, WaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(button));			
		button.click();
	}
	
	//if have new link
	public void ClickTo(String xpath, String URL) {
		WebElement button = driver.findElement(By.xpath(xpath));
		
		WebDriverWait wait = new WebDriverWait(driver, WaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(button));			
		button.click();
		
		FluentWait<WebDriver> urlchangewait = new FluentWait<WebDriver>(driver)
				.withTimeout(this.NavWaitTimeOut)
				.pollingEvery(this.PollingMilSec)
				.ignoring(NoSuchElementException.class);
		urlchangewait.until(ExpectedConditions.urlToBe(URL));
	}
	
	//if need to open new tab
	public String ClickNewTab(String xpath, String URL) {
		WebElement button = driver.findElement(By.xpath(xpath));
		
		WebDriverWait wait = new WebDriverWait(driver, WaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(button));			
		button.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String newTabWindowHandle = "";
		while(iterator.hasNext()) {
			newTabWindowHandle = iterator.next();
		}
		driver.switchTo().window(newTabWindowHandle);
		
		FluentWait<WebDriver> urlchangewait = new FluentWait<WebDriver>(driver)
				.withTimeout(this.NavWaitTimeOut)
				.pollingEvery(this.PollingMilSec)
				.ignoring(NoSuchElementException.class);
		urlchangewait.until(ExpectedConditions.urlToBe(URL));
		return newTabWindowHandle;
	}
	
	public String GetText(String xpath) {
		WebElement Location = driver.findElement(By.xpath(xpath));
		return Location.getText();
	}
	
	public String GetTextCSS(String CSS) {
		WebElement Location = driver.findElement(By.cssSelector(CSS));
		return Location.getText();
	}
	
	public String[] GetTexts(String xpath) {
		List<WebElement> locations = driver.findElements(By.xpath(xpath));
		int size = locations.size();
		//System.out.println(size);
		String[] result = new String[size];
		for(int i = 0; i < size; i++) {
			result[i] = locations.get(i).getText();
		}
		return result;
	}
	
	public DriverDocPage SwitchBackTo(String Url, String WindowHandle) {
		/*
		if (Url == this.LinksUrl) {
			driver.switchTo().window(WindowHandle);
			return new DriverLinkPage(driver);
		}
		*/
		throw new IllegalArgumentException("you just entered an unsupported website URL: " + Url);
	}
}
