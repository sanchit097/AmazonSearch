package com.assignment.AmazonSearch.utilities;

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
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
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

	    System.setProperty(CHROME_DRIVER_PROPERTY, getConfigReader().getDriverPath());
	    driver = new ChromeDriver();
	    break;
	case INTERNETEXPLORER:
	    System.setProperty(IE_DRIVER_PROPERTY,getConfigReader().getDriverPath());

	    driver = new InternetExplorerDriver();
	    break;
	case FIREFOX:
	    System.setProperty(FIREFOX_DRIVER_PROPERTY, getConfigReader().getDriverPath());
	    driver = new FirefoxDriver();
	    break;
	default:
	    System.setProperty(CHROME_DRIVER_PROPERTY, getConfigReader().getDriverPath());
	    driver = new ChromeDriver();
	    break;
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
    
    public void closeDriver() throws Exception {
	driver.quit();
	Thread.sleep(2000);
	driver=null;
    }
}
