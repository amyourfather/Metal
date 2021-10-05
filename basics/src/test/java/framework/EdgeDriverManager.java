package framework;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	private final String DriverName = "msedgedriver.exe";
	private final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.edge.driver";

	public void createDriver() {
		String filePathName = ClassLoader.getSystemResource(DriverName).getFile();
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, filePathName);

		this.setDriver(new EdgeDriver());
	}
}
