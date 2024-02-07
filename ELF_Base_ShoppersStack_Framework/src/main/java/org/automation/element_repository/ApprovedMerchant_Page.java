package org.automation.element_repository;

import org.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ApprovedMerchant_Page extends BasePage {

	public ApprovedMerchant_Page(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//button[text()='Approved Merchant']")
	private WebElement ApprovedMerchantTab;
	@FindBy(xpath = "//button[@aria-label='Profile Info']")
	private WebElement ProfileInfoIcon;
	@FindBy(xpath = "//button[@aria-label='Product Info']")
	private WebElement ProductInfoIcon;
	@FindBy(xpath = "//button[@aria-label='Edit Profile']")
	private WebElement EditProfileIcon;
	@FindBy(xpath = "//button[text()='BLOCK']")
	private WebElement BlockButton;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmationYes;
	
	
	
	public WebElement getApprovedMerchantTab() {
		return ApprovedMerchantTab;
	}

	
	public WebElement getProfileInfoIcon() {
		return ProfileInfoIcon;
	}
	public WebElement getProductInfoIcon() {
		return ProductInfoIcon;
	}
	public WebElement getEditProfileIcon() {
		return EditProfileIcon;
	}
	public WebElement getBlockButton() {
		return BlockButton;
	}
	public WebElement getConfirmationYes() {
		return confirmationYes;
	}
	
	
	
	public void blockMerachantMethod() throws InterruptedException
	{
		BlockButton.click();
		Thread.sleep(1000);
		getUtilityMethods().acceptConfirmation(confirmationYes);
	}
	

}
