package com.gameduell.qa.acceptance.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gameduell.qa.baseclass.TestBaseClass;
import com.gameduell.qa.config.ReadTestPropertyFile;
import com.gameduell.qa.pages.BasePage;

public class AcceptanceTest extends TestBaseClass{

	@Test
	public void validateEndToEndFlow() {
		BasePage basePage = new BasePage(driver);
		boolean isAccountBalanceEqual = basePage
				.clickNewUserRegistration()
				.registerNewUser(ReadTestPropertyFile.getValidUserName(), ReadTestPropertyFile.getValidUserPassword(), ReadTestPropertyFile.getValidUserEmail())
				.clickOnMyGameDuell()
				.validateAccountBalance();

		String emailValidateUrl = basePage
				.logout()
				.loginGameDuell(ReadTestPropertyFile.getValidUserName(), ReadTestPropertyFile.getValidUserPassword())
				.getEmailValidationCurrentUrl();
		String expectedEmailValidationUrl = "https://my.gameduell.com//gd/emailManagement/emailValidation.xhtml";
		Assert.assertTrue(isAccountBalanceEqual, "account balance does not match");
		Assert.assertEquals(emailValidateUrl, expectedEmailValidationUrl, "Does not match");

	}
}
