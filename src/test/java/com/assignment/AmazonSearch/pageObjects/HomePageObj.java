package com.assignment.AmazonSearch.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.assignment.AmazonSearch.utilities.SeleniumBase;

public class HomePageObj {

    WebDriver driver;
    SeleniumBase seleniumBase;
    private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 10;

    public HomePageObj(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
	seleniumBase = new SeleniumBase(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Amazon")
    private WebElement amazonLogo;

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement homePageSearchTxtBox;

    @FindBys({ @FindBy(how = How.ID, using = "nav-search"), @FindBy(how = How.TAG_NAME, using = "form"),
	    @FindBy(how = How.CSS, using = "input[type='submit']") })
    private WebElement SearchBtn;

    @FindBy(how = How.ID, using = "a-autoid-0-announce")
    private WebElement sortingBtn;

    @FindBy(how = How.CLASS_NAME, using = "s-result-list")
    private WebElement productOption;

    @FindBy(how = How.ID, using = "productTitle")
    private WebElement productTitle;

    @FindBy(how = How.ID, using = "s-result-sort-select")
    private WebElement sortDrpDwn;

    public boolean checkHomePage() {

	SeleniumBase.waitForElement(homePageSearchTxtBox, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	return homePageSearchTxtBox.isDisplayed();
    }

    public void enterSearchTxt(String txt) {

	homePageSearchTxtBox.sendKeys(txt);
    }

    public void clickSearchBtn() {

	SeleniumBase.waitForElementClickable(SearchBtn, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	SearchBtn.click();
    }

    public void sortResultbyOption(String sortingOptn) throws InterruptedException {

	SeleniumBase.waitForElementClickable(sortingBtn, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	sortingBtn.click();
	Actions builder = new Actions(driver);
	Action mouseOverDrpDwn = builder.moveToElement(sortDrpDwn).build();
	mouseOverDrpDwn.perform();
	driver.findElement(By.linkText(sortingOptn)).click();
    }

    public void clickProductWithIndex(int index) {
	SeleniumBase.waitForElement(productOption,ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	WebElement expectedIndexProduct = productOption
		.findElement(By.cssSelector("div[data-index = '" + (index - 1) + "']"));
	expectedIndexProduct.findElement(By.cssSelector("img[data-image-index='" + (index - 1) + "']")).click();
    }

    public boolean checkProductTitleContains(String title) {
	
	SeleniumBase.waitForElement(productTitle, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	return productTitle.getText().trim().toLowerCase().contains(title);

    }
}
