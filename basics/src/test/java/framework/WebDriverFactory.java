package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		if(driverType.equals("Chrome")) {
			return new ChromeDriverManager();
		}
		if(driverType.equals("Edge")) {
			return new EdgeDriverManager();
		}
		throw new IllegalArgumentException("you just entered an unsupported driver type: " + driverType);
	}
}
