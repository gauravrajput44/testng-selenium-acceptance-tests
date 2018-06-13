package com.gameduell.qa.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * The {@link WaitHelper} class has static methods to wait for
 * {@link WebElement} This {@link WaitHelper} has two methods one is for
 * {@link WebElement} to be visible another one is for {@link WebElement} to be
 * click able.
 * 
 * @author Gaurav Kumar
 */
public class WaitHelper {

	// Time duration for WebElement to be polled.
	private static final int TIME_DURATION = 90000;

	// Polling Frequency
	private static final int POLLING_TIME_DURATION = 1000;

	/**
	 * This is a static method used for {@link WebElement} to be visible. This
	 * method has time out of 20 seconds and has polling time 1 second. This
	 * methods will throw {@link org.openqa.selenium.TimeoutException} if
	 * WebElement does not appear in 20 seconds. This method ignores
	 * {@link org.openqa.selenium.NoSuchElementException} and
	 * {@link org.openqa.selenium.StaleElementReferenceException} for given
	 * time.
	 * 
	 * @param driver : {@link WebDriver}
	 * @param element : {@link WebElement}
	 */
	public static void waitForWebElementToBeVisible(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(TIME_DURATION, TimeUnit.MILLISECONDS);
		wait.pollingEvery(POLLING_TIME_DURATION, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This is a static method used for {@link WebElement} to be click able. This
	 * method has time out of 20 seconds and has polling time 1 second. This
	 * methods will throw {@link org.openqa.selenium.TimeoutException} if
	 * WebElement does not appear in 20 seconds. This method ignores
	 * {@link org.openqa.selenium.NoSuchElementException} and
	 * {@link org.openqa.selenium.StaleElementReferenceException} for given
	 * time.
	 * 
	 * @param driver : {@link WebDriver}
	 * @param element : {@link WebElement}
	 */
	public static void waitForWebElementToBeClickable(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(TIME_DURATION, TimeUnit.MILLISECONDS);
		wait.pollingEvery(POLLING_TIME_DURATION, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
