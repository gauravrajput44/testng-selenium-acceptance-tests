/**
 * 
 */
package com.gameduell.qa.baseclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.gameduell.qa.browserfactory.BrowserFactory;
import com.gameduell.qa.config.ReadTestPropertyFile;

/**
 * The {@link TestBaseClass} class has two methods. This class is extended by
 * all the test scripts class to initialize the driver session and to quit the
 * driver session.
 * 
 * @author Gaurav Kumar
 */
public class TestBaseClass {

	protected WebDriver driver;
	ReadTestPropertyFile properties;

	/**
	 * This method is used to initialize the driver session before any test
	 * script to run. This method takes argument from the testng.xml file.
	 * 
	 * @param browserName
	 *            : Browser name coming from the testng.xml parameter tag of type
	 *            {@link String}
	 */
	@BeforeClass
	@Parameters("browserName")
	public void initDriverSession(String browserName) {
		properties = new ReadTestPropertyFile();
		driver = BrowserFactory.getWebDriver(browserName);
		driver.manage().window().maximize();
		driver.get(ReadTestPropertyFile.getUrl());
	}

	/**
	 * Quit the driver after finishing the test script run.
	 */
	@AfterClass
	public void closeDriverSession() {
		//driver.quit();
	}
}
