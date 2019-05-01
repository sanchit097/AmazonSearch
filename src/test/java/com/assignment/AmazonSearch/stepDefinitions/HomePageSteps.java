package com.assignment.AmazonSearch.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.assignment.AmazonSearch.pageObjects.HomePageObj;
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

    public HomePageSteps(TestContext context) {
	pageObjectManager = context.getPageObjectManager();
	homepageObj = pageObjectManager.getHomePageObj();
    }

    @Given("^user search for \"([^\"]*)\" in searchbox$")
    public void user_search_for_in_searchbox(String keyword) throws Exception {
	homepageObj.enterSearchTxt(keyword);
	homepageObj.clickSearchBtn();
    }

    @When("^user sort it by \"([^\"]*)\"$")
    public void user_sort_it_by(String sortingOptn) throws Exception {
	homepageObj.sortResultbyOption(sortingOptn);
    }

    @When("^select details \"([^\"]*)\" from list$")
    public void select_details_from_list(int index) throws Exception {
	homepageObj.clickProductWithIndex(index);
    }

    @Then("^Product with keyword \"([^\"]*)\" should be present$")
    public void product_with_key_should_be_present(String titleKeyWord) throws Exception {
	assertTrue(homepageObj.checkProductTitleContains(titleKeyWord));
    }

}
