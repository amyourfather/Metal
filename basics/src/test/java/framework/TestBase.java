package framework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import automationPractice.foundation.DriverDocPage;

public class TestBase {
	private DriverManager DManager;
	protected WebDriver driver;
	protected DriverDocPage DriverDocPage;

	@Before
	public void Preinit() {
		ReadProperties readproperties = new ReadProperties();
		String browsertype = "";
		try {
			browsertype = readproperties.ReadBrowserType();
		} catch(Exception ex) {
			throw new RuntimeException("property file not found in the classpath");
		}
		
		DManager = WebDriverFactory.getManager(browsertype);
		DManager.createDriver();
		driver = DManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void cleanup(){
		DManager.quitDriver();
	}
	
	//Nanda added
	public WebDriver getDriver() {
		return this.DManager.getDriver();
	}
}
