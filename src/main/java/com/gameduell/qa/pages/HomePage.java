package com.gameduell.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.gameduell.qa.utils.WaitHelper;


public class HomePage {

	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='k00userAccount']/p")
	@CacheLookup
	private WebElement accountBalanceInMyGameDuellOverview;
	
	@FindBy(how = How.CSS, using = "a[title='Upgrade now']")
	@CacheLookup
	private WebElement accountBalanceInAccountBox;	
	
	@FindBy(how = How.ID, using = "topNaviMygdLink")
	@CacheLookup
	private WebElement myGameDuell;
	
	public boolean validateAccountBalance() {
		if (getAccountBalanceFromMyGameDuellOverview() != null && getAccountBalanceInAccountBox() !=null) {
			if (getAccountBalanceFromMyGameDuellOverview().contains(getAccountBalanceInAccountBox()))
				return true;
		}
		return false;
	}
	
	public HomePage clickOnMyGameDuell() {
			WaitHelper.waitForWebElementToBeVisible(driver, accountBalanceInAccountBox);
			WaitHelper.waitForWebElementToBeClickable(driver, myGameDuell);
			myGameDuell.click();
			return this;
	}
	
	public String getEmailValidationCurrentUrl() {
		WaitHelper.waitForWebElementToBeVisible(driver, accountBalanceInAccountBox);
		return driver.getCurrentUrl();
	}
	private String getAccountBalanceFromMyGameDuellOverview() {
		WaitHelper.waitForWebElementToBeVisible(driver, accountBalanceInMyGameDuellOverview);
		System.out.println("account balance in my gameduell overview " + accountBalanceInMyGameDuellOverview.getText());
		
		return accountBalanceInMyGameDuellOverview.getText();
	}
	
	private String getAccountBalanceInAccountBox() {
		WaitHelper.waitForWebElementToBeVisible(driver, accountBalanceInAccountBox);
		System.out.println("account balance in account box " + accountBalanceInAccountBox.getText());
		return accountBalanceInAccountBox.getText();
	}
}
