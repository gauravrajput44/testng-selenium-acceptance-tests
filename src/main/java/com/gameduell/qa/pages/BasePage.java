package com.gameduell.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gameduell.qa.utils.WaitHelper;

/**
 * The {@link BasePage} class represents {@link WebElement} and corresponding
 * methods. This {@link BasePage} class has relevant WebElement and methods for
 * login and navigate to registration page.
 *
 * @author Gaurav Kumar
 */
public class BasePage {
	private final WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!"GameDuell: Online Games - Real People, Real Prizes".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Base page");
		}
	}	
	//WebElements
	@FindBy(how = How.CSS, using = "input[name='j_username']")
	@CacheLookup
	private WebElement userName;

	@FindBy(how = How.CSS, using = "input[name='j_password']")
	@CacheLookup
	private WebElement userPassword;

	@FindBy(how = How.ID, using = "loginLink")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "newHereLink")
	@CacheLookup
	private WebElement registerNewUser;
	
	@FindBy(how = How.ID, using = "logoutLink")
	@CacheLookup
	private WebElement logout;
	/**
	 * Click on New User registration link
	 * 
	 * @return 
	 * 			: Home Page
	 */
	public RegistrationPage clickNewUserRegistration() {
		WaitHelper.waitForWebElementToBeClickable(driver, registerNewUser);
		registerNewUser.click();
		return new RegistrationPage(driver);

	}

	/**
	 * Login to GameDuell
	 * 
	 * @param email
	 *            : User's email of type {@link String}
	 * @param password
	 *            : User's password of type {@link String}
	 *            
	 * @return 
	 * 			: Home Page
	 */
	public HomePage loginGameDuell(String email, String password) {
		WaitHelper.waitForWebElementToBeVisible(driver, userName);
		fillUserName(email);
		fillUserPassword(password);
		clickOnLoginButton();
		return new HomePage(driver);
	}	
	
	public BasePage logout() {
		WaitHelper.waitForWebElementToBeClickable(driver, logout);
		logout.click();
		return this;
	}
	/**
	 * fill user's name.
	 * 
	 * @param email
	 *            : User's email of type {@link String}
	 */
	private void fillUserName(String user) {
		userName.clear();
		userName.sendKeys(user);
	}

	/**
	 * fill user's password.
	 * 
	 * @param password
	 *            : User's password of type {@link String}
	 */
	private void fillUserPassword(String password) {
		userPassword.clear();
		userPassword.sendKeys(password);
	}

	/**
	 * click on sign in after filling user's email and user's password.
	 */
	private void clickOnLoginButton() {
		loginButton.click();
	}

}
