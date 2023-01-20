package qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	Properties prop;

	public String readConfig(String propToRead) {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} 
		catch (IOException e) {

			String s = e.getMessage();

			System.out.println("Message from the property file reading exception" + s);
		}

		String value = prop.getProperty(propToRead);

		return value;

	}
	
	
	}
