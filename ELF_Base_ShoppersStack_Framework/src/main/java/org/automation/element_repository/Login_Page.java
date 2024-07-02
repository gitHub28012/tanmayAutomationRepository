package org.automation.element_repository;

import java.util.Scanner;

import org.automation.base.BasePage;
import org.automation.generic_utilities.InitObjects;
import org.automation.generic_utilities.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BasePage{

	public Login_Page(WebDriver driver) {
		super(driver);
		
	}

	
	//================Web elements or Property================
	public String loginAs;
	
	@FindBy(xpath = "//button[text()='Shopper Login']")
	private WebElement ShopperLoginButton;
	@FindBy(xpath = "//button[text()='Merchant Login']")
	private WebElement MerchantLoginButton;
	@FindBy(xpath = "//button[text()='Admin Login']")
	private WebElement AdminLoginButton;
	@FindBy(id="Email")
	private WebElement EmailTextBox;
	@FindBy(id="Password")
	private WebElement PasswordTextBox;
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement LoginButton;

	
	//================Getters or Public services================
	
	public WebElement getShopperLoginButton() {
		return ShopperLoginButton;
	}
	public WebElement getMerchantLoginButton() {
		return MerchantLoginButton;
	}
	public WebElement getAdminLoginButton() {
		return AdminLoginButton;
	}
	public WebElement getEmailTextBox() {
		return EmailTextBox;
	}
	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	// initObject

       
	 
	
	
	//operational Methods 
	public void login(String email,String password,String loginAs)
	{
	  
	//  this.loginAs=System.getProperty(loginAs);
	  if(loginAs.equalsIgnoreCase("Shopper"))
	  {
		  ShopperLoginButton.click();
	  }
	  else if(loginAs.equalsIgnoreCase("Merchant"))
	  {
		  MerchantLoginButton.click();
	  }
	  else if(loginAs.equalsIgnoreCase("Admin"))
	  {
		  AdminLoginButton.click();
	  }
	  else {
		  System.out.println("Wrong login as!!!");
	  }
	  EmailTextBox.sendKeys(email);
	  PasswordTextBox.sendKeys(password);
	  LoginButton.click();
	}
	
	
	
}
