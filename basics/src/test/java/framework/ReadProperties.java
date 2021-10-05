package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public String ReadBrowserType() throws IOException {
		Properties properties = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		properties.load(inputStream);
		inputStream.close();
		
		return properties.getProperty("BrowserType");
	}
}
