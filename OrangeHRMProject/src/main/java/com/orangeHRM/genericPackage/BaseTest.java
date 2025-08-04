package com.orangeHRM.genericPackage;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class BaseTest extends InitObjects{ 
	
	protected static WebDriver driver;
	 @BeforeTest
	 public void reportSetup()
	 {
		 extents=getExtents();
		 sparkReporter=getSparkReporter("./ReportsExtents/"+LocalDateTime.now().toString().replace(":","-"));
	 }
	 
	 @BeforeClass
	 public void setUp() {
		 
		    sparkReporter.config().setDocumentTitle("My BDD DOCUMENT");
		    sparkReporter.config().setTheme(Theme.STANDARD);
		    extents.attachReporter(sparkReporter);
		     
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 }
	 
	 @AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 

}
