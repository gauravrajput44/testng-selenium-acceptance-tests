package com.gameduell.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

/**
 * The {@link ReadTestPropertyFile} class has static methods to read test
 * properties. Test properties has lot of information. For e.g. user name,
 * Password etc. This class has methods to read all the properties from
 * dropBoxTest.property file.
 * 
 * @author Gaurav Kumar
 */
public class ReadTestPropertyFile {

	private final static String CHROME_EXE_PATH = "chromeExePath";
	private final static String FIREFOX_EXE_PATH = "fireFoxExePath";
	private final static String APPLICATION_URL = "applicationnUrl";
	private final static String VALID_USER_EMAIL = "validUserEmail";
	private final static String VALID_USER_PASSWORD = "validUserPassword";
	private final static String VALID_USER_NAME = "validUserName";

	private static Properties property;

	/**
	 * Constructor : Load the input test property file.
	 */
	public ReadTestPropertyFile() {
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("gameduell.property");
		property = new Properties();
		if (stream != null){
			
			try {
				property.load(stream);
				Reporter.log("Property file is loaded", true);
			} catch (IOException e) {
				new RuntimeException("Property file is not loaded");
			}
		} else {
			System.out.println("Something wrong!!!");
		}
	}

	/**
	 * Fetches the chrome executable path from test property file.
	 * @return chrome executable path of type {@link String}
	 */
	public static String getChromeExePath() {
		return property.getProperty(CHROME_EXE_PATH);
	}
	
	/**
	 * Fetches the firefox executable path from test property file.
	 * @return firefox executable path of type {@link String}
	 */
	public static String getFireFoxExePath() {
		return property.getProperty(FIREFOX_EXE_PATH);

	}

	/**
	 * Fetches the application Url from test property file.
	 * @return application Url  of type {@link String}
	 */
	public static String getUrl() {
		return property.getProperty(APPLICATION_URL);

	}

	/**
	 * Fetches the valid user's email.
	 * @return valid user's email ID of type {@link String}
	 */
	public static String getValidUserEmail() {
		return property.getProperty(VALID_USER_EMAIL);
	}

	/**
	 * Fetches the valid user's password
	 * @return valid user's password of type {@link String}
	 */
	public static String getValidUserPassword() {
		return property.getProperty(VALID_USER_PASSWORD);
	}
	
	/**
	 * Fetches the valid user's name.
	 * @return valid user's name of type {@link String}
	 */
	public static String getValidUserName() {
		return property.getProperty(VALID_USER_NAME);
	}
}
