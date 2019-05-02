package com.assignment.AmazonSearch.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.assignment.AmazonSearch.enums.DriverType;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "resources/configuration/config.properties";

    public ConfigFileReader() {
	BufferedReader reader;
	try {
	    reader = new BufferedReader(new FileReader(propertyFilePath));
	    properties = new Properties();
	    properties.load(reader);
	    reader.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public String getDriverPath() {
	String driverPath = properties.getProperty("driverPath");
	if (driverPath != null)
	    return driverPath;
	else
	    throw new RuntimeException("Driverpath not specified in the Config.properties file");
    }

    public DriverType getBrowserType() {
	String browser = properties.getProperty("browser");
	if (browser == null || browser.equalsIgnoreCase("chrome"))
	    return DriverType.CHROME;
	else if (browser == null || browser.equalsIgnoreCase("internetexplorer"))
	    return DriverType.INTERNETEXPLORER;
	else if (browser == null || browser.equalsIgnoreCase("firefox"))
	    return DriverType.FIREFOX;
	else
	    throw new RuntimeException("Driverpath not specified in the Config.properties file");
    }

}
