package org.automation.base;

import java.lang.reflect.Method;
import java.time.Duration;

import java.util.Scanner;

import org.automation.element_repository.Home_Page;
import org.automation.element_repository.Login_Page;
import org.automation.generic_utilities.InitObjects;
import org.automation.generic_utilities.ReadTestData;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class BaseTest extends InitObjects {

	@BeforeTest
	public void reporterSetup() {
		extents = getExtentsReports();
		spark = getExtentSparkReporter(methodName());
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void browserSetUp(@Optional("noValue") String browserValue) throws InvalidBrowserValueException {

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My reports");
		extents.attachReporter(spark);

		readData = new ReadTestData();

		if (browserValue.equalsIgnoreCase("noValue")) {
			browserValue = readData.readDataFromPropertyFile("browser");

			if (browserValue.equalsIgnoreCase("null")) {
				// test.info("Incorrect browserV!!Please cross Check");
				Reporter.log("Incorrect browserV!!Please cross Check", true);
				throw new InvalidBrowserValueException();
			}
		}

		if (browserValue.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			// test.info("ChromeBrowser launched!!");
			Reporter.log("ChromeBrowser launched!!", true);
		} else if (browserValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			Reporter.log("EdgeBrowser launched!!", true);
		} else {
			Reporter.log("Invalid BrowserValue!!", true);
		}

		driver.manage().window().maximize();
		// test.info("browser maximized successfully!!");
		Reporter.log("browser maximized successfully!!", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
		explicitwait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));

	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication(Method method) {
        
		test = extents.createTest(method.getName()).assignAuthor("Tanmay").assignCategory("FTC")
				.assignDevice("Windows");
		url = readData.readDataFromPropertyFile("url");
		driver.get(url);
		loginPage = new Login_Page(driver);
		explicitwait.until(ExpectedConditions.visibilityOf(loginPage.getWelcome_Page_LoginButton()));
		loginPage.getWelcome_Page_LoginButton().click();
		System.out.println("Login as!!");
	    Scanner sc = new Scanner(System.in);
	 //   String loginAs = new InitObjects().getUtilityMethods().sentInputThroughCmd();
	//	String loginAs = System.getProperty("loginAs");
	    String data=sc.next();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.login(readData.readDataFromPropertyFile("email"), readData.readDataFromPropertyFile("password"),
			data);

	}

	@AfterMethod(alwaysRun = true)
	public void logoutOfApplication() throws InterruptedException {
		new Home_Page(driver).logOut();
	}

	@AfterClass(alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
	}

	@AfterTest
	public void reportsTearDown() {
		extents.flush();
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
