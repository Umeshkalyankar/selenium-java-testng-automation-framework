package utilitieslayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static final Properties properties = new Properties();

	static {
		try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {

			properties.load(file);

		} catch (IOException e) {
			// Local configuration file is unavailable in CI.
		}

		// Environment variables override file values when provided.
		loadFromEnvironment("browser", "BROWSER");
		loadFromEnvironment("url", "APP_URL");
		loadFromEnvironment("email", "APP_EMAIL");
		loadFromEnvironment("password", "APP_PASSWORD");
		loadFromEnvironment("invalidEmail", "INVALID_EMAIL");
		loadFromEnvironment("invalidPassword", "INVALID_PASSWORD");
		loadFromEnvironment("signupName", "SIGNUP_NAME");
		loadFromEnvironment("signupMobile", "SIGNUP_MOBILE");
		loadFromEnvironment("signupPassword", "SIGNUP_PASSWORD");
	}

	private static void loadFromEnvironment(String propertyName, String environmentName) {

		String value = System.getenv(environmentName);

		if (value != null && !value.isBlank()) {
			properties.setProperty(propertyName, value.trim());
		}
	}

	public static String getProperty(String key) {
		String value = properties.getProperty(key);

		if (value == null || value.isBlank()) {
			throw new RuntimeException("Missing configuration property: " + key);
		}

		return value.trim();
	}
}
