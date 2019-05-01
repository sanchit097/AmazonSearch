package com.assignment.AmazonSearch.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {

    private static final int WAIT_ALL_ELEMENT_VISIBILITY = 10;
  

    static WebDriver driver;

    public SeleniumBase(WebDriver webdriver) {

	driver = webdriver;

    }

    // Is Element Present

    /**
     * @param element
     *            - {@link WebElement}.
     * @return true if element present; else false.
     */
    public static boolean isElementPresent(final WebElement element) {
	try {
	    element.getTagName();
	} catch (final NoSuchElementException ignored) {
	    return false;
	} catch (final StaleElementReferenceException ignored) {
	    return false;
	} catch (final java.util.NoSuchElementException ignored) {
	    return false;
	}
	return true;
    }

    // Is Element Visible

    /**
     * @param element
     *            - {@link WebElement}.
     * @return true if element visible; else false.
     */
    public static boolean isElementVisible(final WebElement element) {
	return element.isDisplayed();

    }

    /**
     * Wait for {@link WebElement} is clickable.
     * 
     * @param element
     *            - {@link WebElement}.
     * 
     */
    public static void waitForElementClickable(final WebElement element, int timeInSec) {
	final WebDriverWait wait = new WebDriverWait(driver, timeInSec);
	wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    
    /**
     * Wait for {@link WebElement} is present.
     * 
     * @param element
     *            - {@link WebElement}.
     * @param timeoutInSeconds
     *            - How long the {@link WebDriver} wait for element.
     */
    public static void waitForElement(final WebElement element, final int timeoutInSeconds) {
	final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	try {
	    wait.until(ExpectedConditions.visibilityOf(element));
	} catch (StaleElementReferenceException ignore) {
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	} catch (TimeoutException ignore) {

	}

    }

    // Wait For Element Is Invisible

    /**
     * Wait for {@link WebElement} is invisible. 5 seconds, tops.
     * 
     * @param by
     *            - {@link WebElement} as {@link By} object.
     */
    public static void waitForElementIsVisible(final By by) {
	final WebDriverWait wait = new WebDriverWait(driver, WAIT_ALL_ELEMENT_VISIBILITY);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void sleep(final int millis) {
	try {
	    Thread.sleep(millis);
	} catch (final InterruptedException e) {
	    // Nothing happens.
	}
    }

    public static WebElement findElementFromList(String elem, List<WebElement> elemList) {
	
	for (WebElement element : elemList) {
	    waitForElementClickable(element, WAIT_ALL_ELEMENT_VISIBILITY);
	    if (element.getText().equalsIgnoreCase(elem) || element.getText().contains(elem)) {
		return element;
	    }
	}
	return null;
    }
}
