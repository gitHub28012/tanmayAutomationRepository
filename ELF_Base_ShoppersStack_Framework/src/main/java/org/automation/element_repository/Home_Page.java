package org.automation.element_repository;

import org.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Home_Page extends BasePage {

	public Home_Page(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(xpath = "//button[@aria-label='Account settings']")
	private WebElement AccountSettingsIcon;
	@FindBy(css = "path[d*='m17 7']")
	private WebElement LogoutLink;
	
	
	
	@FindBy(xpath = "//button[text()='Merchant Request']") 
	private WebElement MearchantRequest;
	
	
	
	
	public WebElement getAccountSettingsIcon() {
		return AccountSettingsIcon;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}


	public WebElement getMearchantRequest() {
		return MearchantRequest;
	}


	
	//operational Method

	public void logOut() throws InterruptedException
	{
		Thread.sleep(2000);
		AccountSettingsIcon.click();
		Thread.sleep(1000);
		LogoutLink.click();
	}

	
}
