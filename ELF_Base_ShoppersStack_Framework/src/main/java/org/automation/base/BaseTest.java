package org.automation.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.automation.element_repository.Home_Page;
import org.automation.element_repository.Login_Page;
import org.automation.generic_utilities.InitObjects;
import org.automation.generic_utilities.ReadTestData;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public abstract class BaseTest extends InitObjects {

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void browserSetUp(@Optional("noValue") String browserValue) throws InvalidBrowserValueException {
		readData=new ReadTestData();
		
		if(browserValue.equalsIgnoreCase("noValue"))
		{
		   browserValue = readData.readDataFromPropertyFile("browser");
		
		if(browserValue.equalsIgnoreCase("null"))
		{
			Reporter.log("Incorrect browserV!!Please cross Check",true);
			throw new InvalidBrowserValueException();
		}
		}
		
		if(browserValue.equalsIgnoreCase("Chrome"))
		{   
			driver=new ChromeDriver();
			Reporter.log("ChromeBrowser launched!!",true);
		}
		else if(browserValue.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("EdgeBrowser launched!!",true);
		}
		else 
		{
			Reporter.log("Invalid BrowserValue!!",true);
		}
		
		driver.manage().window().maximize();
		Reporter.log("browser maximized successfully!!",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
		explicitwait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_TIMEOUT));


	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication()
	{
		url=readData.readDataFromPropertyFile("url");
		driver.get(url);
		loginPage=new Login_Page(driver);
	    explicitwait.until(ExpectedConditions.visibilityOf(loginPage.getWelcome_Page_LoginButton()));
	    loginPage.getWelcome_Page_LoginButton().click();
		System.out.println("Login as!!");
		Scanner sc = new Scanner(System.in);
		loginPage.login(readData.readDataFromPropertyFile("email"),readData.readDataFromPropertyFile("password"),sc.next());
		
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void logoutOfApplication() throws InterruptedException
	{
		new Home_Page(driver).logOut();
	}
	
	@AfterClass(alwaysRun = true)
	public void browserTearDown()
	{
		driver.quit();
	}

	
	
	// *****************************************************************************
	// ==============================Custom Exceptions==============================
	// *****************************************************************************

	@SuppressWarnings("serial")
	class InvalidBrowserValueException extends Exception {
		public InvalidBrowserValueException() {
			super("Please provide browser value either in XML file or property file");
		}
	}

}
