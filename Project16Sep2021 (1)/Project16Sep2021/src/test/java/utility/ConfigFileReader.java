package utility;

import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;
	private final static String filepath = "./src/test/resources/config/config.properties";

	public static String getProperties(String key) {
		try {
			FileReader reader = new FileReader(filepath);
			properties = new Properties();
			properties.load(reader);
		} catch (Exception e) {
		}
		
		return properties.get(key).toString();
	}

}
