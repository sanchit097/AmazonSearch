package com.assignment.AmazonSearch.stepDefinitions;

import static org.junit.Assert.assertTrue;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.assignment.AmazonSearch.pageObjects.HomePageObj;
import com.assignment.AmazonSearch.utilities.Log;
import com.assignment.AmazonSearch.utilities.PageObjectManager;
import com.assignment.AmazonSearch.utilities.TestContext;
import com.assignment.AmazonSearch.utilities.WebDriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BackgroundSteps {

    WebDriver driver;
    HomePageObj homepageObj;
    PageObjectManager pageObjectManager;
    TestContext context;
    public static Logger logger;

    public BackgroundSteps(TestContext context) {
	this.context = context;
	pageObjectManager = context.getPageObjectManager();
	homepageObj = pageObjectManager.getHomePageObj();
	Log.loadlog4j("log4j.xml");
	logger= Log.getLog(BackgroundSteps.class.getName());
    }

    @Given("^I open the web browser$")
    public void i_open_the_web_browser() throws Exception {
	logger.info(".................Web driver is loaded.................");
	driver = new WebDriverManager().getDriver();
    }

    @When("^I enter url$")
    public void i_enter_url(List<String> url) throws Exception {
	logger.info("................."+url+ "Url is entered in web browser.................");
	driver.get(url.get(0));
    }

    @Then("^I should be navigated to homepage$")
    public void i_should_be_navigated_to_homepage() throws Exception {
	assertTrue(homepageObj.checkHomePage());
    
    }

}
