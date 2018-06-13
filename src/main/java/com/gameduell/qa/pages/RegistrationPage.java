package com.gameduell.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gameduell.qa.utils.WaitHelper;

public class RegistrationPage {

	private final WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.CSS, using = "input[name='commonName']")
	@CacheLookup
	private WebElement userName;

	@FindBy(how = How.CSS, using = "input[name='password']")
	@CacheLookup
	private WebElement userPassword;

	@FindBy(how = How.CSS, using = "input[name='email']")
	@CacheLookup
	private WebElement userEmail;	

	@FindBy(how = How.ID, using = "registrationButton")
	@CacheLookup
	private WebElement registrationButton;

	/** 
	 * fill user's details for registration
	 * @param name
	 * 			   :  User's name of type {@link String}
	 * @param password 
	 * 				   : User's password of type {@link String}
	 * @param email
	 * 				: User's email of type {@link String}
	 * @return
	 * 			: Home Page
	 */
	public HomePage registerNewUser(String name, String password, String email) {
		fillNewUserDetails(name, password, email);
		return new HomePage(driver);

	}
	/**
	 * fill new user's name.
	 * 
	 * @param user
	 *            : User's name of type {@link String}
	 */
	private void fillUserName(String user) {
		WaitHelper.waitForWebElementToBeVisible(driver, userName);
		userName.clear();
		userName.sendKeys(user);
	}

	/**
	 * fill new user's password.
	 * 
	 * @param password
	 *            : User's password of type {@link String}
	 */
	private void fillUserPassword(String password) {
		WaitHelper.waitForWebElementToBeVisible(driver, userPassword);
		userPassword.clear();
		userPassword.sendKeys(password);
	}
	/**
	 * fill new user's email.
	 * 
	 * @param email
	 *            : User's email of type {@link String}
	 */
	private void fillUserEmaild(String email) {
		WaitHelper.waitForWebElementToBeVisible(driver, userEmail);
		userEmail.clear();
		userEmail.sendKeys(email);
	}
	/**
	 * click on new user registration after filling user's email and user's password.
	 */
	private void clickOnNewUserRegistrationButton() {
		WaitHelper.waitForWebElementToBeClickable(driver, registrationButton);
		registrationButton.click();
	}

	/** fill user's details for registration
	 * @param name
	 * 			   :  User's name of type {@link String}
	 * @param password 
	 * 				   : User's password of type {@link String}
	 * @param email
	 * 				: User's email of type {@link String}
	 */
	private void fillNewUserDetails(String name, String password, String email) {
		fillUserName(name);
		fillUserPassword(password);
		fillUserEmaild(email);
		clickOnNewUserRegistrationButton();
	}
}
