package org.automation.element_repository;

import org.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Page extends BasePage{

	public Search_Page(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "search")
	private WebElement searchTextField;
	@FindBy(id = "searchBtn")
	private WebElement searchIcon;
	
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
   public void searchProduct(String productName) throws InterruptedException
   {
	   Thread.sleep(1000);
	   searchTextField.sendKeys(productName);
	   Thread.sleep(1000);
	   searchIcon.click();
   }

}
