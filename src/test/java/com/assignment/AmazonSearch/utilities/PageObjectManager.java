package com.assignment.AmazonSearch.utilities;

import org.openqa.selenium.WebDriver;

import com.assignment.AmazonSearch.pageObjects.HomePageObj;

public class PageObjectManager {

	private WebDriver driver;
	private HomePageObj homePageObj;
	
	public PageObjectManager(WebDriver webDriver) {
		this.driver= webDriver;
	}
	
	public HomePageObj getHomePageObj() {
		return (homePageObj == null) ? homePageObj = new HomePageObj(driver) : homePageObj;
	}
}
