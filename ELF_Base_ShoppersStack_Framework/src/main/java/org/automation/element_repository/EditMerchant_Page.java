package org.automation.element_repository;

import org.automation.base.BasePage;
import org.automation.generic_utilities.InitObjects;
import org.automation.generic_utilities.JavaScriptUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditMerchant_Page extends BasePage{

	public EditMerchant_Page(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(id="first-name")
	private WebElement MerchantFirstNameTextBox;
	@FindBy(id="last-name")
	private WebElement MerchantLastNameTextBox;
	@FindBy(id = "email")
	private WebElement MerchantEmailTextBox;
	@FindBy(id = "phone-number")
	private WebElement MerchantPhoneNumberTextBox;
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement UpdateButton;
	
	
	public WebElement getMerchantFirstNameTextBox() {
		return MerchantFirstNameTextBox;
	}
	public WebElement getMerchantLastNameTextBox() {
		return MerchantLastNameTextBox;
	}
	public WebElement getMerchantEmailTextBox() {
		return MerchantEmailTextBox;
	}
	public WebElement getMerchantPhoneNumberTextBox() {
		return MerchantPhoneNumberTextBox;
	}
	public WebElement getUpdateButton() {
		return UpdateButton;
	}
	
	
	
	public void editMerchant_Method(String FirstName,String LastName,String email,String phoneNo) throws InterruptedException
	{
	
	   Assert.assertEquals(MerchantFirstNameTextBox.isDisplayed(),true);	
	
	   Thread.sleep(1000);   
	   MerchantFirstNameTextBox.clear();
	   Thread.sleep(1000);
	   MerchantFirstNameTextBox.sendKeys(FirstName);
	   MerchantLastNameTextBox.clear();
	   Thread.sleep(1000);
	   MerchantLastNameTextBox.sendKeys(LastName);
	   MerchantEmailTextBox.clear();
	   Thread.sleep(1000);
	   MerchantEmailTextBox.sendKeys(email);
	   MerchantPhoneNumberTextBox.clear();
	   Thread.sleep(1000);
	   MerchantPhoneNumberTextBox.sendKeys(phoneNo);
       InitObjects initObj = new InitObjects();
       initObj.getJavaScriptUtil(driver).scrollTillParticularElement(UpdateButton);
       initObj.getJavaScriptUtil(driver).jsClick(UpdateButton);
	   
	}
	

}
