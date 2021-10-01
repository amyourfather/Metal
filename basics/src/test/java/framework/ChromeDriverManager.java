package framework;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	private final String DriverName = "chromedriver.exe";
	private final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver"; 
	public void createDriver(){
		String filePathName = ClassLoader.getSystemResource(DriverName).getFile();
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, filePathName);

		this.setDriver(new ChromeDriver());
	}

}
