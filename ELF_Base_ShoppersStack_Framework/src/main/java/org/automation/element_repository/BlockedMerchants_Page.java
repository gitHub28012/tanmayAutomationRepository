package org.automation.element_repository;

import org.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BlockedMerchants_Page extends BasePage {

	public BlockedMerchants_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//button[text()='UNBLOCK']")
    private WebElement UnblockButton;
	
	@FindBy(xpath = "//button[text()='Blocked Merchants']")
	private WebElement BlockedMerchantsTab;
	
	public WebElement getBlockedMerchantsTab() {
		return BlockedMerchantsTab;
	}

	public WebElement getUnblockButton() {
		return UnblockButton;
	}	
	
	public void unblockMearchant() throws InterruptedException
	{  
		Thread.sleep(2000);
	    BlockedMerchantsTab.click();
	    UnblockButton.click();
	}

}
