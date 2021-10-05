package framework;

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
	}

	@After
	public void cleanup(){
		DManager.quitDriver();
	}
}
