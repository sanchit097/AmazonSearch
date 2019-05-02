package com.assignment.AmazonSearch.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.assignment.AmazonSearch.pageObjects.HomePageObj;
import com.assignment.AmazonSearch.utilities.Log;
import com.assignment.AmazonSearch.utilities.PageObjectManager;
import com.assignment.AmazonSearch.utilities.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {

    WebDriver driver;
    HomePageObj homepageObj;
    PageObjectManager pageObjectManager;
    TestContext context;
    public static Logger logger;

    public HomePageSteps(TestContext context) {
	pageObjectManager = context.getPageObjectManager();
	homepageObj = pageObjectManager.getHomePageObj();
	logger = Log.getLog(HomePageObj.class.getName());

    }

    @Given("^user search for \"([^\"]*)\" in searchbox$")
    public void user_search_for_in_searchbox(String keyword) throws Exception {
	logger.info("..............entering search key "+keyword+".................");
	homepageObj.enterSearchTxt(keyword);
	logger.info("...........clicking search button for search ...................");

	homepageObj.clickSearchBtn();
    }

    @When("^user sort it by \"([^\"]*)\"$")
    public void user_sort_it_by(String sortingOptn) throws Exception {
	logger.info(".........sorting result by" + sortingOptn + ".....................");
	homepageObj.sortResultbyOption(sortingOptn);
    }

    @When("^select details \"([^\"]*)\" from list$")
    public void select_details_from_list(int index) throws Exception {
	logger.info(".........selecting result by of index " + index + ".....................");
	homepageObj.clickProductWithIndex(index);
    }

    @Then("^Product with keyword \"([^\"]*)\" should be present$")
    public void product_with_key_should_be_present(String titleKeyWord) throws Exception {
	logger.info(".............checking for title..."+titleKeyWord+"............");
	assertTrue(homepageObj.checkProductTitleContains(titleKeyWord));
	
    }

}
