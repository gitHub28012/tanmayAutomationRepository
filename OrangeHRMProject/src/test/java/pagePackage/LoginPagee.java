package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagee {
	
	@FindBy(name = "username") private WebElement usnTB;
	@FindBy(name = "password") private WebElement passTB;
	@FindBy(xpath = "//button[text()=' Login ']") private WebElement loginButton;
	
	public LoginPagee(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
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

	
	
	public void loginMethod(String usn,String pass)
	{
		usnTB.sendKeys(usn);
		passTB.sendKeys(pass);
		loginButton.click();
	}
	
}
