package com.orangeHRM.genericPackage;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InitObjects {
	
	protected static WebDriver driver;
	public ExtentReports extents;
	public ExtentSparkReporter sparkReporter;
	
	public WebDriver getWebDriver()
	{
		return driver;
	}
	
	
	public ExtentReports getExtents() {
		return new ExtentReports();
	}
	
	
	public ExtentSparkReporter getSparkReporter(String file) {
		return new ExtentSparkReporter(file);
	}

	
	

}
