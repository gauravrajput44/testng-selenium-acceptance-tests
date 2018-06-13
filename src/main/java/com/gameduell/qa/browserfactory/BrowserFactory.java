package com.gameduell.qa.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.gameduell.qa.config.ReadTestPropertyFile;

/**
 * The {@link BrowserFactory} class has static method to return a
 * {@link WebDriver}.
 * 
 * @author Gaurav Kumar
 */
public class BrowserFactory {

	private static WebDriver driver;

	private static final String BROWSER_TYPE_CHROME = "Chrome";
	private static final String BROWSER_TYPE_FIREFOX = "Firefox";
	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";

	/**
	 * @param browser
	 *            : Browser name of type {@link String}
	 * @return {@link WebDriver} instance depends on the parameter browserName of testng.xml.
	 */
	public static WebDriver getWebDriver(String browser) {
		if (browser == null) {
			throw new RuntimeException(" Browser is null: ");
		}

		switch (browser) {
		case BROWSER_TYPE_FIREFOX:
			driver = getFirefoxDriver();
			break;
		case BROWSER_TYPE_CHROME:
			driver = getChromeDriver();
			break;
		default:
			throw new RuntimeException("Please pass either Firefox or Chrome");
		}
		return driver;
	}

	private static WebDriver getChromeDriver() {
		Reporter.log("Initializing the chrome web driver", true);
		System.setProperty(CHROME_DRIVER_KEY, ReadTestPropertyFile.getChromeExePath());
		return new ChromeDriver();
	}

	private static WebDriver getFirefoxDriver() {
		Reporter.log("Initializing the firefox web driver", true);
		System.setProperty(FIREFOX_DRIVER_KEY, ReadTestPropertyFile.getFireFoxExePath());
		return new FirefoxDriver();
	}
}