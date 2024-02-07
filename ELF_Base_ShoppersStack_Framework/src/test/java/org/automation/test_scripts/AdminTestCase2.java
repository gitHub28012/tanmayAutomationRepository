package org.automation.test_scripts;

import org.automation.base.BaseTest;
import org.automation.element_repository.ApprovedMerchant_Page;
import org.automation.element_repository.EditMerchant_Page;
import org.automation.generic_utilities.CustomeListeners;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomeListeners.class)

public class AdminTestCase2 extends BaseTest {
	@Test(alwaysRun = true)
	public void editMerchantByAdmin() throws InterruptedException {
		ApprovedMerchant_Page ap = new ApprovedMerchant_Page(driver);
		explicitwait.until(ExpectedConditions.visibilityOf(ap.getEditProfileIcon()));
		Assert.assertEquals(ap.getEditProfileIcon().isDisplayed(),true);
		ap.getEditProfileIcon().click();
		EditMerchant_Page ep = new EditMerchant_Page(driver);
		String firstName = readData.readAnyDataFromExcelInString("Merchant Info", 1, 0);
		String lastName = readData.readAnyDataFromExcelInString("Merchant Info", 1, 1);
		String emailId = readData.readAnyDataFromExcelInString("Merchant Info", 1, 2);
		String phoneNo = readData.readAnyDataFromExcelInString("Merchant Info", 1, 3);
		ep.editMerchant_Method(firstName, lastName, emailId, phoneNo);

		
	}
}
