package org.automation.generic_utilities;

import java.time.LocalDateTime;

import org.automation.element_repository.Home_Page;
import org.automation.element_repository.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InitObjects implements FrameworkConstants{
	
	public static WebDriver static_driver_ref;
	public static WebDriver driver;
	public ReadTestData readData;
	public WebDriverWait explicitwait;
	public Login_Page loginPage;
	public Home_Page homePage;
	public String url;
	public String email;
	public String password;
	public ExtentReports extents;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public SoftAssert softAssert;
	public System system;
//	public ITestResult result;
	
	
	
	public ActionsUtil getActionsUtil(WebDriver driver)
	{
		return new ActionsUtil(driver);
	}
	
	public JavaScriptUtil getJavaScriptUtil(WebDriver driver)
	{
		return new JavaScriptUtil(driver);
	}
	
	public ReadTestData getReadTestData()
	{
		return new ReadTestData();
	}
	
	public UtilityMethods getUtilityMethods()
	{
		return new UtilityMethods();
	}
	
	public ExtentReports getExtentsReports()
	{
		return new ExtentReports();
	}
	
	public ExtentSparkReporter getExtentSparkReporter(String methodName)
	{
		return new ExtentSparkReporter(EXTENT_REPORTS+methodName);
	}
		
	public String methodName()
	{
		return LocalDateTime.now().toString().replace(":","-");
	}

   public String systemInput(String key)
   {
	   return system.getProperty(key);
   }
   	


	
}
