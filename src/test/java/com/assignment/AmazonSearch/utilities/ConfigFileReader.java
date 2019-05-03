package com.assignment.AmazonSearch.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.assignment.AmazonSearch.enums.DriverType;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "resources/configuration/config.properties";

    public ConfigFileReader() {
	
	try(BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {	    
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
	if (StringUtils.equalsIgnoreCase(browser, "chrome"))
	    return DriverType.CHROME;
	else if (StringUtils.equalsIgnoreCase(browser, "internetexplorer"))
	    return DriverType.INTERNETEXPLORER;
	else if (StringUtils.equalsIgnoreCase(browser,"firefox"))
	    return DriverType.FIREFOX;
	else
	    throw new RuntimeException("Driverpath not specified in the Config.properties file");
    }

}
