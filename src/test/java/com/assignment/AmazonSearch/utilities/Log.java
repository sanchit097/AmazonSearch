package com.assignment.AmazonSearch.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

    @SuppressWarnings("unused")
    private static Logger Log = Logger.getLogger(Log.class.getName());
    
    private static Logger log;
    
    public static void loadlog4j(String file) {
	DOMConfigurator.configure(file);
    }
public static Logger getLog(String classname) {
    return log= Logger.getLogger(classname);
}
}
