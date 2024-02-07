package org.automation.test_scripts;

import org.automation.base.BaseTest;
import org.automation.element_repository.ApprovedMerchant_Page;
import org.automation.element_repository.BlockedMerchants_Page;
import org.automation.generic_utilities.CustomeListeners;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomeListeners.class)

public class AdminTestCase1 extends BaseTest {

	@Test
	public void unblockMerchantByAdmin() throws InterruptedException {
		
		ApprovedMerchant_Page ap = new ApprovedMerchant_Page(driver);
		Assert.assertEquals(ap.getBlockButton().isDisplayed(),true);
		ap.blockMerachantMethod();
		BlockedMerchants_Page bp = new BlockedMerchants_Page(driver);
		explicitwait.until(ExpectedConditions.visibilityOf(bp.getBlockedMerchantsTab()));
		Assert.assertEquals(bp.getBlockedMerchantsTab().isDisplayed(),true);
		bp.unblockMearchant();
	}

	

}
