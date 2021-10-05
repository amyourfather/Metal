package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		if(driverType == "Chrome") {
			return new ChromeDriverManager();
		}
		if(driverType == "Edge") {
			return new EdgeDriverManager();
		}
		throw new IllegalArgumentException("you just entered an unsupported driver type: " + driverType);
	}
}
