package com.assignment.AmazonSearch.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.assignment.AmazonSearch.enums.DriverType;

public class WebDriverManager {

	private static WebDriver driver;

	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static ConfigFileReader configReader;

	public WebDriverManager() {

		driverType = getConfigReader().getBrowserType();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (driverType) {
		case CHROME:
			driver = new ChromeDriver();

		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();

		case FIREFOX:
			driver = new FirefoxDriver();
		default:
			System.setProperty(CHROME_DRIVER_PROPERTY, getConfigReader().getDriverPath());
			driver = new ChromeDriver();
		}

		// for maximizing browser window to fit screen
		driver.manage().window().maximize();
		// for locating element for given amount of time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	private ConfigFileReader getConfigReader() {

		return (configReader == null) ? new ConfigFileReader() : configReader;
	}
}
