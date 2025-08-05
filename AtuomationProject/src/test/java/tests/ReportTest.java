package tests;

import org.testng.annotations.Test;
import base_Package.BaseTest;

public class ReportTest extends BaseTest {

	@Test
	public void searchTest() {
		eTest.assignAuthor("Tanmay").assignCategory("FTC").assignDevice("windows");
		eTest.info("I am capturing the page title");
		String title = driver.getTitle();
		eTest.info("capture title as :" + title);
		if (title.equals("google")) {
			eTest.pass("title is verified :" + title);
		} else {
			eTest.fail("title is not verified :" + title);
			eTest.addScreenCaptureFromBase64String(init.getGenMethods().screenShotOfWebPage(driver));
		}
	}
}
