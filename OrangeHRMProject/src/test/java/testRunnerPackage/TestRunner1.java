package testRunnerPackage;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "E:/tanmayworkspace/OrangeHRMProject/Features/OrangeHRM.feature", glue = {
		"stepDefinations" }, plugin = { "pretty", "html:target/cucumber-report.html" })

public class TestRunner1 extends AbstractTestNGCucumberTests  {
	
	

}
