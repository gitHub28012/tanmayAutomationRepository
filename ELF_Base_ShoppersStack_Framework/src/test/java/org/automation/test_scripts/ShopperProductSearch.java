package org.automation.test_scripts;

import org.automation.base.BaseTest;
import org.automation.element_repository.Search_Page;
import org.automation.generic_utilities.CustomeListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomeListeners.class)

public class ShopperProductSearch extends BaseTest {
	
	
	@Test(alwaysRun = true)
	public void productSearchMethod() throws InterruptedException
	{
		
		Search_Page sp = new Search_Page(driver);
		Assert.assertEquals(sp.getSearchTextField().isDisplayed(),true);
		sp.searchProduct(readData.readStringDataFromExcel("ProductData",3,0));
	
		
	}
	
	@Test(alwaysRun = true,dependsOnMethods = "productSearchMethod")
	public void multipleProductSearchMethod() throws InterruptedException
	{
		int rc = readData.getLastRowNum("ProductData");
		for(int i=1;i<=rc;i++)
		{
			Search_Page sp = new Search_Page(driver);
			Assert.assertEquals(sp.getSearchTextField().isDisplayed(),true);
			sp.searchProduct(readData.readStringDataFromExcel("ProductData",i,0));
			
		}
	}

}
