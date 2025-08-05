package base_Package;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.InitObjects;

public abstract class BaseTest extends InitObjects {

	@BeforeTest
	public void reportSetup() {
		extents = getExtentReports();
		spark = getExtentSparkReporter(name());
		init = getInitObject();
		eTest=extents.createTest(name());
		
	}

	@BeforeClass
	public void setUp() {

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extents.attachReporter(spark);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipKart.com");
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
//		if (!Boolean.parseBoolean(Integer.toString(ITestResult.FAILURE))) {
//		   //MediaEntityBuilder.createScreenCaptureFromPath(init.getGenMethods().screenShotOfWebPage(driver)).build();
//			//eTest.fail("failed method : "+ name());
//			//eTest.addScreenCaptureFromPath(init.getGenMethods().screenShotOfWebPage(driver));
//		//	eTest.addScreenCaptureFromBase64String(init.getGenMethods().screenShotOfWebPage(driver));
//		}
		Thread.sleep(2000);
		extents.flush();
		driver.quit();
	}

}
