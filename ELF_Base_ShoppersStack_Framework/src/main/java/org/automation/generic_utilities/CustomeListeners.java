package org.automation.generic_utilities;

import org.automation.base.BaseTest;
import org.testng.ISuite;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CustomeListeners extends BaseTest implements ITestListener {

	public void onFinish(ISuite suite) {
		Reporter.log("About to end executing Suite [" + suite.getName() + "]", true);
	}

	public void onStart(ISuite suite) {
		Reporter.log("About to begin executing Suite [" + suite.getName() + "]", true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "TestCase falied and ScreenShot taken!!", true);
		// UtilityMethods.captureScreen(driver, result);
		InitObjects initClass = new InitObjects();
		initClass.getUtilityMethods().captureScreen(driver, result);
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test [" + result.getName() + "] skipped", true);
	}

	public void onTestStart(ITestResult result) {
		Reporter.log("Execution of the test [" + result.getName() + "] started", true);

	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test [" + result.getName() + "] passed", true);

	}

}
