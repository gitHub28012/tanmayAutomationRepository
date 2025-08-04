package com.orangeHRM.elementRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangeHRM.genericPackage.BasePage;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	private WebElement usnTB;
	@FindBy(name = "password")
	private WebElement passTB;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginButton;

	public LoginPage() {
		super(driver);
	}

	public WebElement getUsnTB() {
		return usnTB;
	}

	public WebElement getPassTB() {
		return passTB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void validLogin(String usn, String pass) {
		usnTB.sendKeys(usn);
		passTB.sendKeys(pass);
		loginButton.click();
	}

}
