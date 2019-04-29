package com.assignment.AmazonSearch.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObj {

	WebDriver driver;

	public HomePageObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
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

	public boolean checkHomePage() {

		return homePageSearchTxtBox.isDisplayed();
	}

	public void enterSearchTxt(String txt) {

		homePageSearchTxtBox.sendKeys(txt);
	}

	public void clickSearchBtn() {

		SearchBtn.click();
	}

	public void sortResultbyOption(String sortingOptn) throws InterruptedException {

		sortingBtn.click();

		Select SortingDropDown = new Select(driver.findElement(By.id("s-result-sort-select")));

		List<WebElement> sortOpt = SortingDropDown.getOptions();

		for (WebElement elm : sortOpt) {
			if (elm.getText().equalsIgnoreCase(sortingOptn)) {
				elm.click();
				break;
			}
		}

	}

	public void clickProductWithIndex(int index) {
		WebElement expectedIndexProduct = productOption
				.findElement(By.cssSelector("div[data-index = '" + (index - 1) + "']"));
		expectedIndexProduct.findElement(By.cssSelector("img[data-image-index='" + (index - 1) + "']")).click();
	}
	
	public boolean checkProductTitleContains(String title) {
		
		return productTitle.getText().trim().toLowerCase().contains(title);
		
	}
}
